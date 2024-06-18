package com.hexagonalArchitecture.task.application.usecases;

import com.hexagonalArchitecture.task.domain.models.Task;
import com.hexagonalArchitecture.task.domain.ports.in.CreateTaskUseCase;
import com.hexagonalArchitecture.task.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
