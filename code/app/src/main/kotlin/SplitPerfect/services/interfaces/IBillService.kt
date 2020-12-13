package SplitPerfect.services.interfaces

import SplitPerfect.domain.Bill
import org.springframework.data.repository.findByIdOrNull

interface IBillService {
    fun addBill(bill: Bill):Bill?
    fun deleteBill(id:Long):Boolean
    fun updateBill(bill: Bill):Boolean
    fun getBill(id:Long): Bill?
    fun findBillByNumber(num:Long): Bill?
    fun getAllBills(): List<Bill>?
}
