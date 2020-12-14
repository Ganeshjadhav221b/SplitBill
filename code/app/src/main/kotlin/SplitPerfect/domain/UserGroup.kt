package SplitPerfect.domain

import java.time.LocalDateTime
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
@Table
 class UserGroup (

    @Id
    @SequenceGenerator(
        name = UserGroup.USER_GROUP_SEQUENCE,
        sequenceName = UserGroup.USER_GROUP_SEQUENCE,
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = UserGroup.USER_GROUP_SEQUENCE)
    var id: Long = 0 ,

    @OneToOne()
    @JoinColumn(name = "fk_user_usergroup")
    var user : User? = null,

    var groups : Long = 0,

    var joined_timestamp:LocalDateTime = LocalDateTime.now(),
    ){

    companion object {
        const val USER_GROUP_SEQUENCE: String = "USER_GROUP_SEQUENCE"
    }
}
