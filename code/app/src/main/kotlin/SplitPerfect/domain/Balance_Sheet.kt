package SplitPerfect.domain

import java.util.*
import javax.persistence.*


@Entity
@Table
class BALANCE_SHEET(
    //This table maintains relation between 2 users.
    @Id
    @SequenceGenerator(
        name = BALANCE_SHEET.BALANCE_SHEET_SEQUENCE,
        sequenceName = BALANCE_SHEET.BALANCE_SHEET_SEQUENCE,
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = BALANCE_SHEET.BALANCE_SHEET_SEQUENCE)
    val Id: Long,
    var date: Date,

    //If balance = x,
    // If balance > 0 means user1 has to get Rs. x from user2
    // If balance < 0 means user2 has to get Rs. x from user1
    var balance: Long,

    //For relation-user performs pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_user_balance_1")
    var user1: User?,

    //For relation-user performs pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_user_balance_2")
    var user2: User?,

    ) {
    companion object {
        const val BALANCE_SHEET_SEQUENCE: String = "BALANCE_SHEET_SEQUENCE"
    }
}
