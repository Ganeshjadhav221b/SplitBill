/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package SplitPerfect

import SplitPerfect.domain.*
import SplitPerfect.services.implementations.*
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime
import SplitPerfect.controllers.UserController as UserController1

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BillTest() {

    @BeforeEach
    fun initialize() {
    }

    @MockBean
    lateinit var userService: UserService

    @MockBean
    lateinit var expenseService: ExpenseService

    @MockBean
    lateinit var billService: BillService

    @MockBean
    lateinit var groupService: GroupService

    @MockBean
    lateinit var userGroupService: UserGroupService

    @Test
    fun checkBillCreation()
    {
        val user1 =  userService.addUser(User(1,"john","john@gmail.com",100))
        val group1 =  groupService.addGroup(Groups(1,"Hunters","we party day and night",null))
        val bill1 = billService.addBill(Bill(1,110,0,0,"hotel ram",null, LocalDateTime.now(),group1))
        assertEquals(bill1, bill1?.let { billService.getBill(it.Id) })
    }

    @Test
    fun checkBillDeletion()
    {
        val user1 =  userService.addUser(User(1,"john","john@gmail.com",100))
        val group1 =  groupService.addGroup(Groups(1,"Hunters","we party day and night",null))
        val bill1 = billService.addBill(Bill(1,110,0,0,"hotel ram",null, LocalDateTime.now(),group1))
        bill1?.let { billService.deleteBill(it.Id) }
        if (bill1 != null) {
            assertEquals(null,expenseService.findExpense(bill1.Id))
        }

    }
}
