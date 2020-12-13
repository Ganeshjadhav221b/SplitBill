package SplitPerfect.controllers

import SplitPerfect.constants.ApplicationConstants.Companion.BASE_USER_URL
import SplitPerfect.domain.User
import SplitPerfect.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [BASE_USER_URL])
class UserController(@Autowired val userService: UserService) {
    @RequestMapping("/")
    fun greet(): String {
        return "Hello wolrd!"
    }

    //Example ->http://localhost:8080/api/v1/user/1
    @GetMapping("/{name}")
    fun findById(@PathVariable name: String): ResponseEntity<List<User>?> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(name))
    }
}
