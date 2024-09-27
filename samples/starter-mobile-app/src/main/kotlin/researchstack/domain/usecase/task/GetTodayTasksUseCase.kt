package researchstack.domain.usecase.task

import researchstack.domain.repository.TaskRepository
import java.time.LocalDateTime
import javax.inject.Inject

class GetTodayTasksUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    operator fun invoke(targetDateTime: LocalDateTime) =
        taskRepository.getTodayTasks(targetDateTime)
}