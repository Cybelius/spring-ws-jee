package com.jee.core.service.jms;

import com.jee.core.model.Calculation;
import com.jee.core.repository.CalculationTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by Geoffrey on 26.06.2018
 */
@Component
public class CalculationTransactionReceiver {

    /**
     */
    private static final Logger log = LoggerFactory.getLogger(CalculationTransactionReceiver.class);

    /**
     */
    @Autowired
    private CalculationTransactionRepository calculationTransactionRepository;

    /**
     * @param calculation the calculation to save
     */
    @JmsListener(destination = "calculationTransactionQueue", containerFactory = "myFactory")
    public void receiveMessage(final Calculation calculation) {
        log.info("Received <" + calculation + ">");

        this.calculationTransactionRepository.saveAndFlush(calculation);
    }
}
