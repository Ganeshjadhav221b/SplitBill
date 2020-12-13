package SplitPerfect.services.implementations

import SplitPerfect.domain.Groups
import SplitPerfect.reposoitories.GroupRepository
import SplitPerfect.services.interfaces.IGroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GroupService(@Autowired val groupsRepository: GroupRepository) : IGroupService {

    override fun addGroup(group: Groups): Groups? = groupsRepository.save(group)

    override fun findGroupById(Id: Long): Groups? = groupsRepository.getGroupById(Id)

    override fun deleteGroup(id: Long) = groupsRepository.delete(id)

    override fun update(name: String, description: String, id: Long) = groupsRepository.update(name, description, id)
}
