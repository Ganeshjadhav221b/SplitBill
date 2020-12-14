package SplitPerfect.services.implementations

import SplitPerfect.domain.BalanceSheet
import SplitPerfect.domain.Bill
import SplitPerfect.domain.Transaction
import SplitPerfect.domain.User
import SplitPerfect.reposoitories.TransactionRepository
import SplitPerfect.services.interfaces.IExpenseService
import SplitPerfect.services.interfaces.ITransactionService
import SplitPerfect.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class TransactionService(
    @Autowired val transactionRepository: TransactionRepository,
    @Autowired val userService: IUserService,
    @Autowired val utilityService: UtilityService
) : ITransactionService {
    override fun addTransaction(transaction: Transaction,updatePayer:Boolean): Transaction? {

        var user1: User? = transaction.user1?.Id?.let { userService.getUser(it) }
        var user2: User? = transaction.user2?.Id?.let { userService.getUser(it) }

        if (user1 == null || user2 == null)
            return null

        //1. update balance sheet
        utilityService.updateBalanceSheet(user1, user2, transaction.amount)

        //2. update user
        if (!this.updateUser(user1, user2, amount = transaction.amount,updatePayer))
            return null

        //3. update bill balance
        if (!this.updateBillBalance(transaction))
            return null

        //4. add to transaction table
        return transactionRepository.save(transaction)
    }

    private fun updateBillBalance(transaction: Transaction): Boolean {
        val bill: Bill? = transaction.bill
        if (bill == null)
            return false
        bill.total_balance -= transaction.amount
        return true
    }

    private fun updateUser(user1: User, user2: User, amount: Long,updatePayer:Boolean): Boolean {
        user2.balance -= amount
        if (updatePayer) {
            user1.balance += amount
            userService.updateUser(user1)
        }
        return userService.updateUser(user2)
    }
}
