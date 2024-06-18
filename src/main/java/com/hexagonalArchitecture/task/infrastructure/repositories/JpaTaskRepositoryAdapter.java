package com.hexagonalArchitecture.task.infrastructure.repositories;

import com.hexagonalArchitecture.task.domain.models.Task;
import com.hexagonalArchitecture.task.domain.ports.out.TaskRepositoryPort;
import com.hexagonalArchitecture.task.infrastructure.entities.TaskEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {
    private final JpaTaskRespository jpaTaskRespository;

    public JpaTaskRepositoryAdapter(JpaTaskRespository jpaTaskRespository) {
        this.jpaTaskRespository = jpaTaskRespository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRespository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRespository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRespository.findAll().stream().map(TaskEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Task> update(Task task) {
        if(jpaTaskRespository.existsById(task.getId())){
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity updateTaskEntity = jpaTaskRespository.save(taskEntity);
            return Optional.of(updateTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaTaskRespository.existsById(id)){
            jpaTaskRespository.deleteById(id);
            return true;
        }
            return false;
    }
}
