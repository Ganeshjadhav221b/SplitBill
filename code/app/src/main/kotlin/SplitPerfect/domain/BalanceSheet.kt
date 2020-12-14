package SplitPerfect.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*


@Entity
@Table
class BalanceSheet(
    //This table maintains relation between 2 users.
    @Id
    @SequenceGenerator(
        name = BalanceSheet.BALANCE_SHEET_SEQUENCE,
        sequenceName = BalanceSheet.BALANCE_SHEET_SEQUENCE,
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = BalanceSheet.BALANCE_SHEET_SEQUENCE)
    val Id: Long = 0,
    var timestamp: LocalDateTime = LocalDateTime.now() ,

    //If balance = x,
    // If balance > 0 means user1 has to get Rs. x from user2
    // If balance < 0 means user2 has to get Rs. x from user1
    var balance: Long = 0,

    //For relation-user pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_user_1_balance_sheet", insertable = true)
    var user1: User? = null,

    //For relation-user pays/repays against expenses.
    @OneToOne
    @JoinColumn(name = "fk_user_2_balance_sheet", insertable = true)
    var user2: User? = null,

    ) {
    companion object {
        const val BALANCE_SHEET_SEQUENCE: String = "BALANCE_SHEET_SEQUENCE"
    }
}
