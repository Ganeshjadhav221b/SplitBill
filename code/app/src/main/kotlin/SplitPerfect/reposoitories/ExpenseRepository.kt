package SplitPerfect.reposoitories

import SplitPerfect.domain.Expense
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository : JpaRepository<Expense, Long>
