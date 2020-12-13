package SplitPerfect.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*


@Entity
@Table
class User(

    @Id
    @SequenceGenerator(name = USER_SEQUENCE, sequenceName = USER_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = USER_SEQUENCE)
    val Id: Long,
    var name: String,
    var email: String,
    var balance: Long,
    var deletion_timestamp: LocalDateTime?,

    //Followiing the conventions for foreignKey->
    //FK_ForeignTableName_CurrentTableName

    //For relation-user is part of group.
    @ManyToMany
    @JoinTable(
        name = "user_group",
        joinColumns = arrayOf(JoinColumn(name = "fk_group_user")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "fk_user_group"))
    )
    var groups: Set<Groups>

) {
    constructor():this(1,"","",0,null,setOf<Groups>())
    companion object {
        const val USER_SEQUENCE: String = "USER_SEQUENCE"
    }
}
