package SplitPerfect.reposoitories

import SplitPerfect.domain.BalanceSheet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
interface BalanceSheetRepository : JpaRepository<BalanceSheet, Long> {
    @Transactional
    @Modifying
    @Query("update balance_sheet set balance = ?1, timestamp =  CURRENT_TIMESTAMP() where id = ?2", nativeQuery = true)
    fun update(balance: Long, id: Long): Int

    @Query("select * from balance_sheet where (fk_user_1_balance_sheet = ?1 and fk_user_2_balance_sheet = ?2)", nativeQuery = true)
    fun findBalanceSheet(user1: Long, user2:Long): BalanceSheet?
}
