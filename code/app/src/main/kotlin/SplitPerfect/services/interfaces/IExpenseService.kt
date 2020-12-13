package SplitPerfect.services.interfaces

import SplitPerfect.domain.Expense

interface IExpenseService {
    fun addExpense(expense: Expense): Expense?
    fun findExpense(Id: Long): Expense?
    fun deleteExpense(id: Long)
}
