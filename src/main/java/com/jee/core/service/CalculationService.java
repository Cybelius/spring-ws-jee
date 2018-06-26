package com.jee.core.service;

import com.jee.core.service.model.ServiceOut;

/**
 * Created by Geoffrey on 26.06.2018
 */
public interface CalculationService {

    /**
     * @return a {@link ServiceOut}
     */
    ServiceOut getCalculatedMetrics();
}
