package com.jee.core.service.support;

import com.jee.core.model.Calculation;
import com.jee.core.repository.CalculationTransactionRepository;
import com.jee.core.service.model.calculation.CalculationOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jee.core.service.CalculationService;
import com.jee.core.service.model.ServiceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

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
}
