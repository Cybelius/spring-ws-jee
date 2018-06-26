package com.jee.core.controller;

import com.jee.core.service.model.DeviceAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Geoffrey on 26.06.2018
 */
@RestController
@RequestMapping("/back-office")
public class BOTransactionController extends AbstractController {

    /**
     */
    private static final Logger log = LoggerFactory.getLogger(BOTransactionController.class);

    /**
     */
    @GetMapping("/devices")
    public List<DeviceAPI> getdevices() {
        final List<DeviceAPI> devices = super.getListDevices();

        log.info(devices.toString());

        //return the result
        return devices;
    }
}
