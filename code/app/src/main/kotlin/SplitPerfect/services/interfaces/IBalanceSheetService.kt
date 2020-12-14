package SplitPerfect.services.interfaces

import SplitPerfect.domain.BalanceSheet

interface IBalanceSheetService {
     fun addBalanceSheet(balanceSheet: BalanceSheet): BalanceSheet?
     fun updateBalanceSheet(balanceSheet: BalanceSheet): Int?
}
