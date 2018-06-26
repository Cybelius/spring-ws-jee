package com.jee.core.controller;

import com.jee.core.model.Calculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Geoffrey on 26.06.2018
 */
@RestController
@RequestMapping("/transaction")
public class CalculationTransactionController {

    /**
     */
    private static final Logger log = LoggerFactory.getLogger(CalculationTransactionController.class);

    /**
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * Endpoint for calculation engine
     * Retrieve a JSON file and convert this JSON file into the Jms Queue
     *
     * @param transaction the transaction to save
     */
    @PostMapping("/result-calculation")
    public void send(@RequestBody final Calculation transaction) {
        log.info("Sending a transaction to JMS instance Queue - calculationTransactionQueue");

        // Post message to the message queue named "OrderTransactionQueue"
        jmsTemplate.convertAndSend("calculationTransactionQueue", transaction);
    }
}
