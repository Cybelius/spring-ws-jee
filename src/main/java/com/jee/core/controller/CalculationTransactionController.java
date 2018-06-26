package com.jee.core.controller;

import com.jee.core.model.Calculation;
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
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * Endpoint for calculation engine
     * Retrieve a JSON file and convert this JSON file into the Jms Queue
     *
     * @param transaction the transaction to save
     */
    @PostMapping("/send")
    public void send(@RequestBody Calculation transaction) {
        System.out.println("Sending a transaction.");

        // Post message to the message queue named "OrderTransactionQueue"
        jmsTemplate.convertAndSend("calculationTransactionQueue", transaction);
    }
}
