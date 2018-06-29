package com.jee.core.controller;

import com.jee.core.model.CalculatedData;
import com.jee.core.model.Calculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
     * Endpoint for calculation engine -> **** RAW metrics ****
     * Retrieve a JSON file and convert this JSON file into the Jms Queue
     *
     * @param calculation the transaction to save
     */
    @PostMapping("/raw-calculation")
    public void send(@RequestBody final Calculation calculation) {
        log.info("Sending a transaction to JMS instance Queue - calculationTransactionQueue");

        // Post message to the message queue named "OrderTransactionQueue"
        jmsTemplate.convertAndSend("calculationTransactionQueue", calculation);
    }

    /**
     * Endpoint for calculation engine only for **** historic average data and calculated values ****
     * Retrieve a JSON file and convert this JSON file into the Jms Queue
     *
     * @param calculation the transaction to save
     */
    @PostMapping("/data-calculated")
    public void send(@RequestBody final CalculatedData calculation) {
        log.info("Sending a transaction to JMS instance Queue - dataCalculatedTransactionQueue");

        final Date date = new Date();
        calculation.setDate(date.getTime());

        // Post message to the message queue named "OrderTransactionQueue"
        jmsTemplate.convertAndSend("dataCalculatedTransactionQueue", calculation);
    }

}
