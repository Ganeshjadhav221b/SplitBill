package SplitPerfect.domain

import java.util.*
import javax.persistence.*


@Entity
@Table
class Expense(

    @Id
    @SequenceGenerator(name = EXPENSE_SEQUENCE, sequenceName = EXPENSE_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EXPENSE_SEQUENCE)
    val Id: Long,
    val name: String,
    var deletion_date: Date,
    var payment_date: Date,

    //Followiing the conventions for foreignKey->
    //FK_ForeignTableName_CurrentTableName

    //For relation-user pays for an item.
    @ManyToOne
    @JoinColumn(name = "fk_user_expense")
    var user: User?,

    //For relation-item/expense amount is added against the bill.
    @ManyToOne
    @JoinColumn(name = "fk_bill_expense")
    var bill: Bill?
) {

    companion object {
        const val EXPENSE_SEQUENCE: String = "EXPENSE_SEQUENCE"
    }
}
