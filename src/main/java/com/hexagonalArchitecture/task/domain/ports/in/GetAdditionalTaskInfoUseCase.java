package com.hexagonalArchitecture.task.domain.ports.in;

import com.hexagonalArchitecture.task.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
