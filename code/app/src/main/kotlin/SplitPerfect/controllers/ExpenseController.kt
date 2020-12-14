package SplitPerfect.controllers

import SplitPerfect.constants.ApplicationConstants
import SplitPerfect.domain.Expense
import SplitPerfect.services.implementations.ExpenseService
import SplitPerfect.services.interfaces.IExpenseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = [ApplicationConstants.BASE_EXPENSE_URL])
class ExpenseController(@Autowired val expenseService: IExpenseService) {


    //Example ->http://localhost:8080/api/v1/expense/1
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Expense?> {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.findExpense(id))
    }


    //Example ->http://localhost:8080/api/v1/expense/create
    @PostMapping(value = ["/create"], consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun addUser(@RequestBody expense: Expense): ResponseEntity<Long?> {
        return ResponseEntity.ok(expenseService.addExpense(expense)?.Id)
    }

    //Example ->http://localhost:8080/api/v1/expense/delete/1
    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.deleteExpense(id))
    }
}
