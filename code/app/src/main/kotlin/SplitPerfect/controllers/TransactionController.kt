package SplitPerfect.controllers

import SplitPerfect.constants.ApplicationConstants
import SplitPerfect.domain.Expense
import SplitPerfect.domain.Transaction
import SplitPerfect.services.implementations.ExpenseService
import SplitPerfect.services.interfaces.ITransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = [ApplicationConstants.BASE_TRANSACTION_URL])
class TransactionController(@Autowired val transactionService: ITransactionService) {


    //Example ->http://localhost:8080/api/v1/transaction/create
    @PostMapping(value = ["/create"], consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun addTransaction(@RequestBody transaction: Transaction): ResponseEntity<Long?> {
        return ResponseEntity.ok(transactionService.addTransaction(transaction)?.Id)
    }
}
