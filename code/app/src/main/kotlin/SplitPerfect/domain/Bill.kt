package SplitPerfect.domain

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table
class Bill(

    @Id
    @SequenceGenerator(name = BILL_SEQUENCE, sequenceName = BILL_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = BILL_SEQUENCE)
    val Id: Long,
    val number: Long,
    val total_balance: Long,
    val total_expenditure: Long = 0,
    val description: String,
    var deletion_timestamp: LocalDateTime?,
    var creation_timestamp: LocalDateTime,

    //Followiing the conventions for foreignKey->
    //FK_ForeignTableName_CurrentTableName

    //For relation-user for a group may contain many bills.
    @ManyToOne
    @JoinColumn(name = "fk_group_bill")
    var group: Groups?
) {

    constructor() : this(
        0, 0, 0, 0, "",
        null, LocalDateTime.now(),null)


    companion object {
            const val BILL_SEQUENCE: String = "BILL_SEQUENCE"
        }
}
