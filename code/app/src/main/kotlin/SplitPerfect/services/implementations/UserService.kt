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

    override fun findById(id: Long): User? = userRepository.findByIdOrNull(id)

    override fun findAll(): List<User> = userRepository.findAll()

    override fun addUser(user: User): User? = userRepository.save(user)

    override fun updateUser(user: User): Boolean
    {
        if(this.findById(user.Id) == null)
            return false

        return userRepository.update(user.balance,user.name,user.email,user.Id)>0
    }

    override fun deleteUser(id: Long): Boolean
    {
        if(this.findById(id) == null)
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
