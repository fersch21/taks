package com.hexagonalArchitecture.task.application.usecases;

import com.hexagonalArchitecture.task.domain.models.Task;
import com.hexagonalArchitecture.task.domain.ports.in.UpdateTaskUseCase;
import com.hexagonalArchitecture.task.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }
}
