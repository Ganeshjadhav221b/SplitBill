package SplitPerfect.controllers

import SplitPerfect.constants.ApplicationConstants
import SplitPerfect.domain.Groups
import SplitPerfect.services.interfaces.IGroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = [ApplicationConstants.BASE_GROUP_URL])
class GroupController(@Autowired val groupService: IGroupService) {


    //Example ->http://localhost:8080/api/v1/group/1
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Groups?> {
        return ResponseEntity.status(HttpStatus.OK).body(groupService.findGroupById(id))
    }


    //Example ->http://localhost:8080/api/v1/group/create
    @PostMapping(value = ["/create"], consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun addUser(@RequestBody group: Groups): ResponseEntity<Long?> {
        return ResponseEntity.ok(groupService.addGroup(group)?.Id)
    }

    //Example ->http://localhost:8080/api/v1/group/delete/1
    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Int> {
        return ResponseEntity.status(HttpStatus.OK).body(groupService.deleteGroup(id))
    }

    //Example ->http://localhost:8080/api/v1/group/create
    @PutMapping(value = ["/update"], consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun updateUser(@RequestBody group: Groups): ResponseEntity<Int?> {
        return ResponseEntity.ok(groupService.update(group.name,group.description,group.Id))
    }

}
