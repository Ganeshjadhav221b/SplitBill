package SplitPerfect.services.implementations

import SplitPerfect.domain.Bill
import SplitPerfect.reposoitories.BillRepository
import SplitPerfect.services.interfaces.IBillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BillService(@Autowired val billRepository: BillRepository):IBillService {

    override fun addBill(bill: Bill): Bill? = billRepository.save(bill)
    override fun findBillByNumber(number: Long): Bill? = billRepository.findBillByNumber(number)

    override fun updateBill(bill: Bill): Boolean {
        println("HereL ${bill.group?.Id}")
        if (this.getBill(bill.Id) == null)
            return false
        try {
            return billRepository.update(
                bill.total_balance,
                bill.total_expenditure,
                bill.number,
                bill.description,
                bill.group?.Id,
                bill.Id
            ) > 0

        } catch (e: Exception) {
            println("error - $e")
        }
        return false

    }


    override fun getBill(id:Long): Bill? = billRepository.getBill(id)
    override fun getAllBills(): List<Bill>? = billRepository.getAllBills()

    override fun deleteBill(id: Long): Boolean {

        if(this.getBill(id) == null)
            return false
        return billRepository.delete(id)>0
    }
}
