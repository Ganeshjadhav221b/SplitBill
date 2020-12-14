package SplitPerfect.reposoitories

import SplitPerfect.domain.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface TransactionRepository : JpaRepository<Transaction, Long> {

    @Query("select * from transaction where FK_BILL_TRANSACTION = ?1", nativeQuery = true)
    fun getTransactionsByBillId(id: Long):List<Transaction>?
}
