package SplitPerfect.services.implementations

import SplitPerfect.domain.Transaction
import SplitPerfect.reposoitories.TransactionRepository
import SplitPerfect.services.interfaces.ITransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class TransactionService(@Autowired val transactionRepository: TransactionRepository) : ITransactionService {
    override fun addTransaction(transaction: Transaction): Transaction? = transactionRepository.save(transaction)
}
