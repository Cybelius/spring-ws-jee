package com.jee.core.repository;

import com.jee.core.model.CalculatedData;

import java.util.List;

/**
 * Created by Geoffrey on 29.06.2018
 */
public interface DataCalculationTransactionRepositoryEx {

    /**
     */
    List<CalculatedData> findAllByTemperature();

    /**
     */
    List<CalculatedData> findAllByHumidity();

    /**
     */
    List<CalculatedData> findAllByCo2();

    /**
     */
    List<CalculatedData> findAllBySoundLevel();

    /**
     */
    List<CalculatedData> findAllByDates(final long startDate, final long endDate);

}
