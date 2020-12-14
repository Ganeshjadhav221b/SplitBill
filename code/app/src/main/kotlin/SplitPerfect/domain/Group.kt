package SplitPerfect.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table
data class Groups(
    @Id
    @SequenceGenerator(
        name = Groups.GROUP_SEQUENCE,
        sequenceName = Groups.GROUP_SEQUENCE,
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GROUP_SEQUENCE)
    var Id: Long,
    var name: String,
    var description: String,
    var deletion_timestamp: LocalDateTime?,


) {
    constructor():this(1,"","",null)

    companion object {
        const val GROUP_SEQUENCE: String = "GROUP_SEQUENCE"
    }
}
