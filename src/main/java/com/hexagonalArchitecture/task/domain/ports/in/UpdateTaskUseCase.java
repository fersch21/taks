package com.hexagonalArchitecture.task.domain.ports.in;

import com.hexagonalArchitecture.task.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updateTask);
}
