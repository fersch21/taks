package com.hexagonalArchitecture.task.domain.ports.in;

import com.hexagonalArchitecture.task.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
