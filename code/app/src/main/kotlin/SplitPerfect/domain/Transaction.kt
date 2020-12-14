package SplitPerfect.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*


@Entity
@Table
class Transaction(
    //This table maintains transaction record between 2 users, against a bill.
    @Id
    @SequenceGenerator(
        name = Transaction.TRANSACTION_SEQUENCE,
        sequenceName = Transaction.TRANSACTION_SEQUENCE,
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = Transaction.TRANSACTION_SEQUENCE)
    var Id: Long = 0 ,
    var description : String = "",
    var transaction_timestamp:LocalDateTime = LocalDateTime.now() ,
    var amount :Long = 0,

    //For relation-user performs pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_user_1_transaction")
    var user1: User? = null,

    //For relation-user performs pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_user_2_transaction")
    var user2: User? = null,

    //For relation-user performs pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_bill_transaction")
    var bill: Bill? = null,

    ) {
    companion object {
        const val TRANSACTION_SEQUENCE: String = "TRANSACTION_SEQUENCE"
    }
}
