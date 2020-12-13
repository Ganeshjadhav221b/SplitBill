package SplitPerfect.reposoitories

import SplitPerfect.domain.Bill
import SplitPerfect.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface BillRepository:JpaRepository<Bill,Long> {

    @Query("select top 1 * from bill where number = ?1%", nativeQuery = true)
    fun findBillByNumber(number: Long): Bill?

    @Query("select top 1 * from bill where id = ?1 and deletion_timestamp is null", nativeQuery = true)
    fun getBill(id: Long): Bill?


    @Query("select * from bill where deletion_timestamp is null", nativeQuery = true)
    fun getAllBills(): List<Bill>?


    @Transactional
    @Modifying
    @Query("update bill set total_balance = ?1, total_expenditure = ?2, number = ?3,description = ?4, fk_group_bill= ?5 where id = ?6", nativeQuery = true)
    fun update(balance:Long,expenditure:Long,number:Long,description:String,fk:Long?,id:Long): Int

    @Transactional
    @Modifying
    @Query("update bill set deletion_timestamp = CURRENT_TIMESTAMP() where id = ?1", nativeQuery = true)
    fun delete(id:Long): Int

}
