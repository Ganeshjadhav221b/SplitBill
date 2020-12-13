package SplitPerfect.services.implementations

import SplitPerfect.domain.Expense
import SplitPerfect.reposoitories.ExpenseRepository
import SplitPerfect.services.interfaces.IExpenseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ExpenseService(@Autowired val expenseRepository: ExpenseRepository) : IExpenseService {
    override fun addExpense(expense: Expense): Expense? = expenseRepository.save(expense)
    override fun findExpense(Id: Long): Expense? = expenseRepository.findByIdOrNull(Id)
    override fun deleteExpense(id: Long) = expenseRepository.deleteById(id)
}
