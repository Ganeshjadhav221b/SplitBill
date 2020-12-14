package SplitPerfect.services.implementations

import SplitPerfect.domain.Groups
import SplitPerfect.domain.User
import SplitPerfect.reposoitories.UserRepository
import SplitPerfect.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class UserService(@Autowired val userRepository: UserRepository): IUserService {

    override fun findByInitials(name: String): List<User>? = userRepository.findUserByInitials(name)

    //Incase if  deleted user wishes to restore(soft-deleted users will also be included)
    fun findById(id: Long): User? = userRepository.findByIdOrNull(id)

    override fun getUser(id: Long): User?
    {
        try{
            return userRepository.getUser(id)
        }
        catch (e:Exception)
        {
            println("Exception occured while fetching user: $e")
        }
        return null
    }

    override fun getAllUsers(): List<User>? {
        try{
            return userRepository.getAllUsers()
        }
        catch (e:Exception)
        {
            println("Exception occured while fetching users: $e")
        }
        return null
    }

    override fun addUser(user: User): User? = userRepository.save(user)

    override fun updateUser(user: User): Boolean
    {
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
            println("Exception occured while deleting user: $e")
        }
        return false
    }

    override fun getUserBalance(id: Long): String {

        val amount :Long? = userRepository.getBalance(id)
        if(amount == null)
            return "User does not exist or is deleted"
        if(amount<0)
            return "User owes Rs. ${amount*-1} only to other users"
        else if(amount == 0L)
            return "user has Rs. 0 only balance"
        else
            return "Others owe Rs. $amount only to the user"
    }

}
