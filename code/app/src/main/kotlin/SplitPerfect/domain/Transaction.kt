package SplitPerfect.domain

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
    var Id: Long,
    var description : String,
    var transaction_timestamp:Date,

    //For relation-user performs pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_user_transaction_1")
    var user1: User?,

    //For relation-user performs pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_user_transaction_2")
    var user2: User?,


    //For relation-user performs pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_user_expense")
    var bill: Bill?,

    ) {
    companion object {
        const val TRANSACTION_SEQUENCE: String = "TRANSACTION_SEQUENCE"
    }
}
