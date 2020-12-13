package SplitPerfect.services.interfaces

import SplitPerfect.domain.User
import SplitPerfect.reposoitories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


interface IUserService{

    fun findById(id: Long): User?
    fun findByInitials(name: String): List<User>?
    fun findAll(): List<User>
    fun addUser(user: User): User?
    fun updateUser(user: User): Boolean
    fun deleteUser(id:Long): Boolean
}
