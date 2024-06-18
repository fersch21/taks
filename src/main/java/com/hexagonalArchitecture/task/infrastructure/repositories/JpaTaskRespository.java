package com.hexagonalArchitecture.task.infrastructure.repositories;

import com.hexagonalArchitecture.task.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRespository extends JpaRepository<TaskEntity, Long> {
}
