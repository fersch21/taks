package com.hexagonalArchitecture.task.domain.ports.out;

import com.hexagonalArchitecture.task.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
