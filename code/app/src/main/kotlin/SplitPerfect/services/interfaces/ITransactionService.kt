package SplitPerfect.services.interfaces

import SplitPerfect.domain.Transaction


interface ITransactionService {
    fun addTransaction(transaction: Transaction,updatePayer:Boolean): Transaction?
    fun getTransactionsForBill(id: Long): List<Transaction>?

}
