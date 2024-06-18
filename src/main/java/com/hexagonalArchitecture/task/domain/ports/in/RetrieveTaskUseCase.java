package com.hexagonalArchitecture.task.domain.ports.in;

import com.hexagonalArchitecture.task.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask(Long id);
    List<Task> getAllTasks();
}
