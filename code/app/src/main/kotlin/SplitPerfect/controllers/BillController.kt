package SplitPerfect.controllers

import SplitPerfect.constants.ApplicationConstants
import SplitPerfect.domain.Bill
import SplitPerfect.domain.User
import SplitPerfect.services.implementations.BillService
import SplitPerfect.services.interfaces.IBillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [ApplicationConstants.BASE_BILL_URL])
class BillController(@Autowired val billService: IBillService) {


    //Example ->http://localhost:8080/api/v1/bill/billnumber/1
    @GetMapping("/billnumber/{number}")
    fun findByInitials(@PathVariable billNum: Long): ResponseEntity<Bill?> {
        return ResponseEntity.status(HttpStatus.OK).body(billService.findBillByNumber(billNum))
    }

    //Example ->http://localhost:8080/api/v1/bill/1
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Bill?> {
        return ResponseEntity.status(HttpStatus.OK).body(billService.getBill(id))
    }

    //Example ->http://localhost:8080/api/v1/bill/1
    @GetMapping("/")
    fun getAllBills(@PathVariable id: Long): ResponseEntity<List<Bill>?> {
        return ResponseEntity.status(HttpStatus.OK).body(billService.getAllBills())
    }

    //Example ->http://localhost:8080/api/v1/bill/create
    @PostMapping(value = ["/create"],consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun addBill(@RequestBody bill: Bill): ResponseEntity<Long?> {
        return ResponseEntity.ok(billService.addBill(bill)?.Id)
    }

    //Example ->http://localhost:8080/api/v1/bill/update
    @PutMapping(value = ["/update"],consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun updateBill(@RequestBody bill: Bill): ResponseEntity<Boolean> {
        return ResponseEntity.ok(billService.updateBill(bill))
    }

    //Example ->http://localhost:8080/api/v1/bill/delete/1
    @DeleteMapping("/delete/{id}")
    fun deleteBill(@PathVariable id: Long): ResponseEntity<Boolean> {
        return ResponseEntity.status(HttpStatus.OK).body(billService.deleteBill(id))
    }
}
