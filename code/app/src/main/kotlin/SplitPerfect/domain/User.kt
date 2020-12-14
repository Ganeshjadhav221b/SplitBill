package SplitPerfect.domain

import org.hibernate.engine.internal.Cascade
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table
data class User(

    @Id
    @SequenceGenerator(name = USER_SEQUENCE, sequenceName = USER_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = USER_SEQUENCE)
    var Id: Long = 0,
    var name: String = "",
    var email: String = "",
    var balance: Long = 0,
    var deletion_timestamp: LocalDateTime? = null,

    //Followiing the conventions for foreignKey->
    //FK_ForeignTableName_CurrentTableName


    @OneToMany(
        mappedBy = "user",
        cascade = arrayOf(CascadeType.ALL),
    )
    var items: MutableList<Expense> = mutableListOf<Expense>()

) {
    companion object {
        const val USER_SEQUENCE: String = "USER_SEQUENCE"
    }
}
