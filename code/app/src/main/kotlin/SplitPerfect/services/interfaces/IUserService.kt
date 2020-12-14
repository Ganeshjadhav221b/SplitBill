package SplitPerfect.services.interfaces

import SplitPerfect.domain.Groups
import SplitPerfect.domain.User
import SplitPerfect.reposoitories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


interface IUserService{

    fun getUser(id: Long): User?
    fun findByInitials(name: String): List<User>?
    fun getAllUsers(): List<User>?
    fun addUser(user: User): User?
    fun updateUser(user: User): Boolean
    fun deleteUser(id:Long): Boolean
}
