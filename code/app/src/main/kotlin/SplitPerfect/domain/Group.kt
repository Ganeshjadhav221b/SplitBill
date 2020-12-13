package SplitPerfect.domain

import java.util.*
import javax.persistence.*

@Entity
@Table
class Groups(
    @Id
    @SequenceGenerator(
        name = Groups.GROUP_SEQUENCE,
        sequenceName = Groups.GROUP_SEQUENCE,
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GROUP_SEQUENCE)
    val Id: Long,
    var name: String,
    var description: String,
    var deletion_timestamp: Date

) {
    companion object {
        const val GROUP_SEQUENCE: String = "GROUP_SEQUENCE"
    }
}
