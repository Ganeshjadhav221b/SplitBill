package SplitPerfect.services.implementations

import SplitPerfect.domain.BalanceSheet
import SplitPerfect.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UtilityService(@Autowired val balanceSheetService: BalanceSheetService) {
    fun updateBalanceSheet(payer: User, user2: User, amount: Long) {
        //Check if balancesheet already exists, if it does, update it.
        var balanceSheet: BalanceSheet? = BalanceSheet()

        //Since we store single column for balance. we need to know who owes whom.
        var payerFlag:Boolean = true
        balanceSheet= balanceSheetService.findBalanceSheet(payer.Id,user2.Id)
        if(balanceSheet == null)
        {
            balanceSheet= balanceSheetService.findBalanceSheet(user2.Id,payer.Id)
            payerFlag = false
        }

        if(balanceSheet != null)
        {
            if(payerFlag){
                balanceSheet.balance += amount
            }
            else
                balanceSheet.balance -= amount
            balanceSheetService.updateBalanceSheet(balanceSheet)
            return
        }
        balanceSheet = BalanceSheet()
        balanceSheet.user1 = payer
        balanceSheet.user2 = user2
        //Positive amount means user1 has to yet recieve amount from user2
        balanceSheet.balance = amount

        balanceSheetService.addBalanceSheet(balanceSheet)
    }


}
