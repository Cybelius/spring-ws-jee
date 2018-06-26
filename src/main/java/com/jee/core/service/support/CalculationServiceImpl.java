package com.jee.core.service.support;

import com.jee.core.model.Calculation;
import com.jee.core.repository.CalculationTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jee.core.service.CalculationService;
import com.jee.core.service.model.ServiceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @see CalculationService#getCalculatedMetrics()
     */
    @Override
    public ServiceOut getCalculatedMetrics() {
        final List<Calculation> calculation = this.calculationTransactionRepository.findAll();



        return null;
    }
}
