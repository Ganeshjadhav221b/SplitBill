package SplitPerfect.services

import SplitPerfect.domain.User
import SplitPerfect.reposoitories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService(@Autowired val userRepository: UserRepository) {

    fun findById(name: String): List<User>? {
        return userRepository.findUserByFirstLetter(name)
    }
}
