package SplitPerfect.reposoitories

import SplitPerfect.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface UserRepository : JpaRepository<User, Long> {

    @Query("select * from user where name like ?1%", nativeQuery = true)
    fun findUserByInitials(initials: String): List<User>?


    @Query("select top 1 * from user where id = ?1 and deletion_timestamp is  null", nativeQuery = true)
    fun getUser(id: Long): User?

    @Query("select * from user where deletion_timestamp is null", nativeQuery = true)
    fun getAllUsers(): List<User>?

    @Transactional
    @Modifying
    @Query("update user set balance = ?1, name = ?2, email = ?3 where id = ?4", nativeQuery = true)
    fun update(balance:Long,name:String,email:String,id:Long): Int

    @Transactional
    @Modifying
    @Query("update user set deletion_timestamp = CURRENT_TIMESTAMP() where id = ?1", nativeQuery = true)
    fun delete(id:Long): Int

    @Query("select balance from user where deletion_timestamp is null and id = ?1", nativeQuery = true)
    fun getBalance(id: Long): Long?


}
