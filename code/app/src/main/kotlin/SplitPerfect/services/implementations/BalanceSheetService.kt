package SplitPerfect.services.implementations

import SplitPerfect.domain.BalanceSheet
import SplitPerfect.reposoitories.BalanceSheetRepository
import SplitPerfect.services.interfaces.IBalanceSheetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BalanceSheetService(@Autowired val balanceSheetRepository: BalanceSheetRepository) : IBalanceSheetService {

    override fun findBalanceSheetForUser(userId: Long): String {
        var balanceStatement: String = ""
        val balanceSheetList_1: List<BalanceSheet>? = balanceSheetRepository.findBalanceSheetForUser_1(userId)
        val balanceSheetList_2: List<BalanceSheet>? = balanceSheetRepository.findBalanceSheetForUser_2(userId)


        if (balanceSheetList_1 != null)
            balanceStatement += this.getBalanceStatements(balanceSheetList_1,true)

        if (balanceSheetList_2 != null)
            balanceStatement += this.getBalanceStatements(balanceSheetList_2,false)
        if(balanceStatement == "")
            balanceStatement = "User has not done any transactions"
        return balanceStatement
    }

    private fun getBalanceStatements(balancesheetlist: List<BalanceSheet>,isBalanceSheetForUser1:Boolean): String {
        var balanceStatement: String = ""

        for (balanceSheet in balancesheetlist) {
            if ((isBalanceSheetForUser1 && balanceSheet.balance < 0) || ((!isBalanceSheetForUser1 && balanceSheet.balance > 0)))
                balanceStatement += "user owes Rs. ${balanceSheet.balance} only to ${balanceSheet.user2?.name}\n"
            else
                balanceStatement += "${balanceSheet.user2?.name} owes Rs. ${balanceSheet.balance} only to user\n"
        }
        return balanceStatement
    }

    override fun findBalanceSheet(user1Id: Long, user2Id: Long): BalanceSheet? =
        balanceSheetRepository.findBalanceSheet(user1Id, user2Id)

    override fun addBalanceSheet(balanceSheet: BalanceSheet): BalanceSheet? =
        balanceSheetRepository.save(balanceSheet)

    override fun updateBalanceSheet(balanceSheet: BalanceSheet): Int? =
        balanceSheetRepository.update(balanceSheet.balance, balanceSheet.Id)
}
