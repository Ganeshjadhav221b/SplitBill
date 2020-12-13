package SplitPerfect.reposoitories

import SplitPerfect.domain.Groups
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface GroupRepository : JpaRepository<Groups, Long> {


    @Query("select top 1 * from groups where id = ?1 and deletion_timestamp is null", nativeQuery = true)
    fun getGroupById(id: Long): Groups?

    @Query("select * from groups where deletion_timestamp is null", nativeQuery = true)
    fun getAllGroups(): List<Groups>?


    @Transactional
    @Modifying
    @Query("update groups set name = ?1, description = ?2 where id = ?3", nativeQuery = true)
    fun update(name: String, description: String, id: Long): Int

    @Transactional
    @Modifying
    @Query("update groups set deletion_timestamp = CURRENT_TIMESTAMP() where id = ?1", nativeQuery = true)
    fun delete(id: Long): Int

}
