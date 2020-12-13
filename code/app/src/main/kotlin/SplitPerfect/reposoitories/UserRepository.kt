package SplitPerfect.reposoitories

import SplitPerfect.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    @Query("select * from user where name like ?1%", nativeQuery = true)
    fun findUserByFirstLetter(initials: String): List<User>?
}
