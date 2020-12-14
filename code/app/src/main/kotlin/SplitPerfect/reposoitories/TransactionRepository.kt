package SplitPerfect.reposoitories

import SplitPerfect.domain.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface TransactionRepository : JpaRepository<Transaction, Long>
