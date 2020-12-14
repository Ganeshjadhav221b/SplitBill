package SplitPerfect.reposoitories

import SplitPerfect.domain.Groups
import SplitPerfect.domain.User
import SplitPerfect.domain.UserGroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserGroupRepository:JpaRepository<UserGroup,Long> {

    @Query("select fk_user_usergroup from user_group where groups = ?1", nativeQuery = true)
    fun getAllUsersForGroup(groupId:Long): List<Long>?
    //fun findByGroups(groups: Long): List<User>?
}
