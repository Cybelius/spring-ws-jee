package com.jee.core.service;

import com.jee.core.model.Calculation;
import com.jee.core.repository.CalculationTransactionRepository;
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
    @Autowired
    private CalculationTransactionRepository calculationTransactionRepository;

    /**
     * @param calculation the calculation to save
     */
    @JmsListener(destination = "calculationTransactionQueue", containerFactory = "myFactory")
    public void receiveMessage(Calculation calculation) {
        System.out.println("Received <" + calculation + ">");

        this.calculationTransactionRepository.saveAndFlush(calculation);
    }
}
