package SplitPerfect.services.interfaces

import SplitPerfect.domain.Groups

interface IGroupService {

    fun addGroup(group: Groups): Groups?

    fun findGroupById(Id: Long): Groups?

    fun deleteGroup(id: Long): Int

    fun update(name: String, description: String, id: Long): Int

}
