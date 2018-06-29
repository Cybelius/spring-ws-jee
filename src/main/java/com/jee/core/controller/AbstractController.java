package com.jee.core.controller;

import com.jee.core.service.CalculationService;
import com.jee.core.service.model.DeviceAPI;
import com.jee.core.service.model.MetricAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Geoffrey on 26.06.2018
 */
abstract class AbstractController {

    /**
     */
    private static final Logger log = LoggerFactory.getLogger(AbstractController.class);

    /**
     */
    @Autowired
    protected CalculationService calculationService;

    /**
     */
    protected AbstractController() {
        super();
    }

    /**
     *
     * @return the list of devices
     */
    protected List<DeviceAPI> getListDevices() {
        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<List<DeviceAPI>> deviceResponse =
            restTemplate.exchange("http://wcfwebservice.azurewebsites.net/Service.svc/calculs/devices",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<DeviceAPI>>() {
                }
            );

        final List<DeviceAPI> devices = deviceResponse.getBody();

        log.info(devices.toString());

        //return the result
        return devices;
    }

    /**
     *
     * @return the list of devices
     */
    protected DeviceAPI getDevice(@NotNull final Long id) {
        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<DeviceAPI> response =
                restTemplate.exchange("http://wcfwebservice.azurewebsites.net/Service.svc/calculs/devices/device/" + id,
                        HttpMethod.GET, null, new ParameterizedTypeReference<DeviceAPI>() {
                        }
                );

        final DeviceAPI devices = response.getBody();

//        log.info(devices.toString());

        //return the result
        return devices;
    }

    /**
     * //TODO : check if possible to send a device name to get the right device
     * @return the list of devices
     */
    protected List<MetricAPI> getMetricsByDevices(final Long id) {
        log.debug("id: {}", id);

        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<List<MetricAPI>> metricResponse =
                restTemplate.exchange("http://wcfwebservice.azurewebsites.net/Service.svc/calculs/devices/" + id + "/metrics",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<MetricAPI>>() {
                        }
                );

        final List<MetricAPI> metrics = metricResponse.getBody();

        log.info(metrics.toString());

        //return the result
        return metrics;
    }
}
