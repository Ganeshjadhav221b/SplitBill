package SplitPerfect.domain

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

    //For relation-user is part of group.
    @ManyToMany
    @JoinTable(
        name = "user_group",
        joinColumns = arrayOf(JoinColumn(name = "fk_group_user")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "fk_user_group"))
    )
    var groups: MutableList<Groups> = mutableListOf<Groups>(),

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
