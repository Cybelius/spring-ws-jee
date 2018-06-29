package com.jee.core.service;

import com.jee.core.service.model.transitionobject.CalculatedDataOut;
import com.jee.core.service.model.transitionobject.ServiceOut;

import java.util.List;

/**
 * Created by Geoffrey on 26.06.2018
 */
public interface CalculationService {

    /**
     * @return a {@link ServiceOut}
     */
    ServiceOut getCalculatedMetrics();

    /**
     * @return a {@link CalculatedDataOut}
     */
    List<CalculatedDataOut> getDataCalculatedByTemperature();

    /**
     * @return a {@link CalculatedDataOut}
     */
    List<CalculatedDataOut> getDataCalculatedByHumidity();

    /**
     * @return a {@link CalculatedDataOut}
     */
    List<CalculatedDataOut> getDataCalculatedByCo2();

    /**
     * @return a {@link CalculatedDataOut}
     */
    List<CalculatedDataOut> getDataCalculatedBySoundLevel();

    /**
     * @return a {@link CalculatedDataOut}
     */
    List<CalculatedDataOut> getDataCalculatedByDates(final long startDate, final long endDate);
}
