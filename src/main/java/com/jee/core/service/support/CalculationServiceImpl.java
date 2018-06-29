package com.jee.core.service.support;

import com.jee.core.model.CalculatedData;
import com.jee.core.model.Calculation;
import com.jee.core.model.DateType;
import com.jee.core.repository.CalculationTransactionRepository;
import com.jee.core.repository.DataCalculationTransactionRepository;
import com.jee.core.service.model.transitionobject.CalculatedDataOut;
import com.jee.core.service.model.transitionobject.CalculationOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jee.core.service.CalculationService;
import com.jee.core.service.model.transitionobject.ServiceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Geoffrey on 26.06.2018
 */
@Service
public class CalculationServiceImpl implements CalculationService {

    /**
     */
    private final static Logger log = LoggerFactory.getLogger(CalculationServiceImpl.class);

    /**
     */
    @Autowired
    private CalculationTransactionRepository calculationTransactionRepository;

    /**
     */
    @Autowired
    private DataCalculationTransactionRepository dataCalculationTransactionRepository;

    /**
     */
    public CalculationServiceImpl() {
        super();
    }

    /**
     * @see CalculationService#getCalculatedMetrics()
     */
    @Override
    public ServiceOut getCalculatedMetrics() {
        final Collection<Calculation> calculations = this.calculationTransactionRepository.findAll();
        final Collection<CalculationOut> calculationOuts = new ArrayList<>();

        for (final Calculation calculation : calculations) {
            final CalculationOut calculationOut = new CalculationOut(calculation);
            calculationOuts.add(calculationOut);
        }

        //return the result

        final ServiceOut out = new ServiceOut();
        out.setCalculations(calculationOuts);

        return out;
    }

    /**
     * @see CalculationService#getDataCalculatedByTemperature()
     */
    @Override
    public List<CalculatedDataOut> getDataCalculatedByTemperature() {
        final List<CalculatedData> temperatures = this.dataCalculationTransactionRepository.findAllByTemperature();

        //return result

        return this.setCalculatedDataOut(temperatures);
    }

    /**
     * @see CalculationService#getDataCalculatedByHumidity()
     */
    @Override
    public List<CalculatedDataOut> getDataCalculatedByHumidity() {
        final List<CalculatedData> humidities = this.dataCalculationTransactionRepository.findAllByHumidity();

        //return result

        return this.setCalculatedDataOut(humidities);
    }

    /**
     * @see CalculationService#getDataCalculatedByCo2()
     */
    @Override
    public List<CalculatedDataOut> getDataCalculatedByCo2() {
        final List<CalculatedData> co2s = this.dataCalculationTransactionRepository.findAllByCo2();

        //return result

        return this.setCalculatedDataOut(co2s);
    }

    /**
     * @see CalculationService#getDataCalculatedBySoundLevel()
     */
    @Override
    public List<CalculatedDataOut> getDataCalculatedBySoundLevel() {
        final List<CalculatedData> soundLevels = this.dataCalculationTransactionRepository.findAllBySoundLevel();

        //return result

        return this.setCalculatedDataOut(soundLevels);
    }

    /**
     * @see CalculationService#getDataCalculatedByDates(long, long)
     */
    @Override
    public List<CalculatedDataOut> getDataCalculatedByDates(final long startDate, final long endDate) {
        log.info("startDate: {}, endDate: {}", startDate, endDate);

        final List<CalculatedData> results = this.dataCalculationTransactionRepository.findAllByDates(startDate, endDate);


        return null;
    }

    /**
     * hepler function
     *
     * @param entries list of calculated from database
     * @return a list of calculated data
     */
    private List<CalculatedDataOut> setCalculatedDataOut(@NonNull final List<CalculatedData> entries) {
        log.debug("entries: {}", entries);

        final List<CalculatedDataOut> results = new ArrayList<>();

        CalculatedDataOut day = null;
        CalculatedDataOut month = null;
        CalculatedDataOut week = null;

        for (final CalculatedData entry : entries) {
            if(entry.getDateType() == DateType.DAY) {
                day = new CalculatedDataOut(entry);
            } else if (entry.getDateType() == DateType.WEEK) {
                week = new CalculatedDataOut(entry);
            } else {
                month = new CalculatedDataOut(entry);
            }
        }

        results.add(day);
        results.add(month);
        results.add(week);

        return results;
    }




}
