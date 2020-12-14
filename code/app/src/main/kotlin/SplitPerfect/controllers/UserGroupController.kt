package SplitPerfect.controllers

import SplitPerfect.constants.ApplicationConstants
import SplitPerfect.domain.UserGroup
import SplitPerfect.services.implementations.UserGroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = [ApplicationConstants.BASE_USER_URL])
class UserGroupController(@Autowired val userGroupService: UserGroupService)
{
    //Example ->http://localhost:8080/api/v1/users/create
    @PostMapping(value = ["/usergroup"], consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun addUserToGroup(@RequestBody userGroup: UserGroup): ResponseEntity<UserGroup>? {
        try
        {
            return ResponseEntity.ok(userGroupService.addUserToGroup(userGroup))
        }
        catch(e:Exception)
        {
            println("Exception while adding user to group ->$e")
        }
        return null
    }
}
