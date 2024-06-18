package com.hexagonalArchitecture.task.infrastructure.config;

import com.hexagonalArchitecture.task.application.services.TaskService;
import com.hexagonalArchitecture.task.application.usecases.*;
import com.hexagonalArchitecture.task.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonalArchitecture.task.domain.ports.out.ExternalServicePort;
import com.hexagonalArchitecture.task.domain.ports.out.TaskRepositoryPort;
import com.hexagonalArchitecture.task.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonalArchitecture.task.infrastructure.repositories.JpaTaskRepositoryAdapter;
import com.hexagonalArchitecture.task.infrastructure.repositories.JpaTaskRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase){
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }
    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRespositoryAdapter){
        return jpaTaskRespositoryAdapter;
    }
    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }
    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}


