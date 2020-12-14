package SplitPerfect.services.implementations

import SplitPerfect.domain.*
import SplitPerfect.reposoitories.ExpenseRepository
import SplitPerfect.services.interfaces.IExpenseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.math.exp

@Service
class ExpenseService(
    @Autowired val expenseRepository: ExpenseRepository,
    @Autowired val billService: BillService,
    @Autowired val userGroupService: UserGroupService,
    @Autowired val userService: UserService,
    @Autowired val balanceSheetService: BalanceSheetService,
    @Autowired val transactionService: TransactionService
) : IExpenseService {


    override fun addExpense(expense: Expense): Expense? {
        var bill: Bill? = expense.bill?.Id?.let { billService.getBill(it) }

        //If bill not linked.
        if (bill == null)
            return null

        //Added expense to the bill
        bill.total_expenditure += expense.amount

        var payer: User? = expense.user?.Id?.let { userService.getUser(it) }

        //If user doesnt exists
        if (payer == null)
            return null

        //Positive balance indicates that payer has to get the amount back
        payer.balance = expense.amount
        userService.updateUser(payer)

        //If group doesnt exist
        if (bill.group == null)
            return null

        this.updateRecords(bill, payer, expense)
        return expenseRepository.save(expense)
    }

    private fun updateRecords(bill: Bill, payer: User, expense: Expense): Boolean {
        var usersFromGroup: List<User>? = userGroupService.getAllUsersForGroup(bill.group!!.Id)

        val numOfUsersInGroup = usersFromGroup?.size

        //if no users are in group
        if (numOfUsersInGroup == 0)
            return false

        val individualContribution = expense.amount / numOfUsersInGroup!!

        var amountDueTotal: Long = 0
        if (usersFromGroup != null) {
            for (user in usersFromGroup) {
                //Add everyone except the payer
                if (user !== payer) {
                    //Negative balance indicates the user has to yet return due
                    amountDueTotal += individualContribution
                    user.balance -= individualContribution

                    userService.updateUser(user)
                    this.updateTransactions(payer,user,individualContribution,bill)
                    this.updateBalanceSheet(payer, user, individualContribution)
                }
            }
        }

        bill.total_balance += amountDueTotal
        billService.updateBill(bill)
        return true
    }

    private fun updateTransactions(user:User,payer:User,amount:Long,bill: Bill) {
        //Add in transaction table
        var transaction: Transaction = Transaction()
        transaction.bill = bill
        transaction.user1 = payer
        transaction.user2 = user
        transaction.amount = amount
        transactionService.addTransaction(transaction)
    }


    private fun updateBalanceSheet(user1: User, user2: User, amount: Long) {
        var balanceSeet: BalanceSheet = BalanceSheet()
        balanceSeet.user1 = user1
        balanceSeet.user2 = user2
        //Positive amount means user1 has to yet recieve amount from user2
        balanceSeet.balance = amount
        balanceSheetService.addBalanceSheet(balanceSeet)
    }


    override fun findExpense(Id: Long): Expense? = expenseRepository.findByIdOrNull(Id)
    override fun deleteExpense(id: Long) = expenseRepository.deleteById(id)
}
