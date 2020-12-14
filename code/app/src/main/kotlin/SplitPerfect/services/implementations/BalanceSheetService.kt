package SplitPerfect.services.implementations

import SplitPerfect.domain.BalanceSheet
import SplitPerfect.reposoitories.BalanceSheetRepository
import SplitPerfect.services.interfaces.IBalanceSheetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BalanceSheetService(@Autowired val balanceSheetRepository: BalanceSheetRepository) : IBalanceSheetService {

    override fun findBalanceSheet(user1Id:Long, user2Id:Long): BalanceSheet? = balanceSheetRepository.findBalanceSheet(user1Id,user2Id)
    override fun addBalanceSheet(balanceSheet: BalanceSheet): BalanceSheet? = balanceSheetRepository.save(balanceSheet)
    override fun updateBalanceSheet(balanceSheet: BalanceSheet): Int? =
        balanceSheetRepository.update(balanceSheet.balance, balanceSheet.Id)
}
