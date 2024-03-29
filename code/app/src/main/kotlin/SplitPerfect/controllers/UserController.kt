package SplitPerfect.controllers

import SplitPerfect.constants.ApplicationConstants.Companion.BASE_USER_URL
import SplitPerfect.domain.User
import SplitPerfect.domain.UserGroup
import SplitPerfect.services.implementations.BalanceSheetService
import SplitPerfect.services.interfaces.IBalanceSheetService
import SplitPerfect.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@RestController
@RequestMapping(value = [BASE_USER_URL])
class UserController(@Autowired val userService: IUserService, @Autowired val balanceSheetService: IBalanceSheetService) {


    //Example ->http://localhost:8080/api/v1/users/initials/gan
    @GetMapping("/initials/{name}")
    fun findByInitials(@PathVariable name: String): ResponseEntity<List<User>?> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByInitials(name))
    }

    //Example ->http://localhost:8080/api/v1/user/1
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<User?> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id))
    }

    //Example ->http://localhost:8080/api/v1/user/
    @GetMapping("/")
    fun getAllUsers(): ResponseEntity<List<User>?> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers())
    }

    //Example ->http://localhost:8080/api/v1/user/create
    @PostMapping(value = ["/create"],consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun addUser(@RequestBody user: User): ResponseEntity<Long?> {
        return ResponseEntity.ok(userService.addUser(user)?.Id)
    }

    //Example ->http://localhost:8080/api/v1/user/update
    @PutMapping(value = ["/update"])
    fun updateUser(@RequestBody user: User): ResponseEntity<Boolean> {
        return ResponseEntity.ok(userService.updateUser(user))
    }

    //Example ->http://localhost:8080/api/v1/user/delete/1
    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Boolean> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id))
    }

    //Example ->http://localhost:8080/api/v1/user/userbalance/1
    @GetMapping("/userbalance/{id}")
    fun getUserBalance(@PathVariable id: Long): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserBalance(id))
    }


    //Example -> localhost:8080/api/v1/user/userbalancesheet/1
    @GetMapping("/userbalancesheet/{id}")
    fun getUserBalanceSheet(@PathVariable id: Long): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body(balanceSheetService.findBalanceSheetForUser(id))
    }



}
