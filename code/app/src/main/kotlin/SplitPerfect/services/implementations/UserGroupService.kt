package SplitPerfect.services.implementations

import SplitPerfect.domain.User
import SplitPerfect.domain.UserGroup
import SplitPerfect.reposoitories.UserGroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserGroupService(@Autowired var userGroupRepository: UserGroupRepository,
                        @Autowired var userService: UserService) {
    fun addUserToGroup(usergroup: UserGroup):UserGroup {
        return  userGroupRepository.save(usergroup)

    }

    fun getAllUsersForGroup(groups:Long):List<User>? {
        var users: MutableList<User> = mutableListOf<User>()
        //return userGroupRepository.findByGroups(groups)
        val userIds: List<Long>? = userGroupRepository.getAllUsersForGroup(groups)
        if (userIds == null)
            return null
        for (id in userIds) {
            userService.getUser(id)?.let { users.add(it) }
        }
        return users
    }
}
