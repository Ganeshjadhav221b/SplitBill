package SplitPerfect.services.implementations

import SplitPerfect.domain.User
import SplitPerfect.reposoitories.UserRepository
import SplitPerfect.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class UserService(@Autowired val userRepository: UserRepository): IUserService {

    override fun findByInitials(name: String): List<User>? = userRepository.findUserByInitials(name)

    //Incase if  deleted user wishes to restore(soft-deleted will also be included)
    fun findById(id: Long): User? = userRepository.findByIdOrNull(id)

    override fun getUser(id: Long): User? = userRepository.getUser(id)

    override fun getAllUsers(): List<User>? = userRepository.getAllUsers()

    override fun addUser(user: User): User? = userRepository.save(user)

    override fun updateUser(user: User): Boolean
    {
        print("Here: ${user.Id}")
        if(this.getUser(user.Id) == null)
            return false

        return userRepository.update(user.balance,user.name,user.email,user.Id)>0
    }

    override fun deleteUser(id: Long): Boolean
    {
        if(this.getUser(id) == null)
            return false
        try {
            return userRepository.delete(id)>0
        }
        catch (e:Exception)
        {
            println("Here: $e")
        }
        return false
    }
}
