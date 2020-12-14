package SplitPerfect.domain

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table
class Expense(

    @Id
    @SequenceGenerator(name = EXPENSE_SEQUENCE, sequenceName = EXPENSE_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EXPENSE_SEQUENCE)
    var Id: Long = 0,
    var amount: Long = 0,
    var name: String = "",
    var payment_timestamp: LocalDateTime = LocalDateTime.now(),

    //Followiing the conventions for foreignKey->
    //FK_ForeignTableName_CurrentTableName

    //For relation-user pays for an item.
    @ManyToOne
    @JoinColumn(name = "fk_user_expense", insertable = true)
    var user: User? = null,

    //For relation-item/expense amount is added against the bill.
    @ManyToOne
    @JoinColumn(name = "fk_bill_expense", insertable = true)
    var bill: Bill? = null
) {

    companion object {
        const val EXPENSE_SEQUENCE: String = "EXPENSE_SEQUENCE"
    }
}
