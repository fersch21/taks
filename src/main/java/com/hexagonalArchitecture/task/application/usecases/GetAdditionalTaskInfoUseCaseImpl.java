package com.hexagonalArchitecture.task.application.usecases;

import com.hexagonalArchitecture.task.domain.models.AdditionalTaskInfo;
import com.hexagonalArchitecture.task.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonalArchitecture.task.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
