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

import static com.jee.core.Application.CONSTANT_IP_WCF;

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
            restTemplate.exchange(CONSTANT_IP_WCF + "/calculs/devices",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<DeviceAPI>>() {
                }
            );

        //return the result
        return deviceResponse.getBody();
    }

    /**
     *
     * @return the list of devices
     */
    protected DeviceAPI getDevice(@NotNull final Long id) {
        log.debug("id: {}", id);

        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<DeviceAPI> response =
                restTemplate.exchange(CONSTANT_IP_WCF + "/calculs/devices/device/" + id,
                        HttpMethod.GET, null, new ParameterizedTypeReference<DeviceAPI>() {
                        }
                );

        //return the result
        return response.getBody();
    }

    /**
     * //TODO : check if possible to send a device name to get the right device
     * @return the list of devices
     */
    protected List<MetricAPI> getMetricsByDevices(final Long id) {
        log.debug("id: {}", id);

        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<List<MetricAPI>> metricResponse =
                restTemplate.exchange(CONSTANT_IP_WCF + "/calculs/devices/" + id + "/metrics",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<MetricAPI>>() {
                        }
                );

        //return the result
        return metricResponse.getBody();
    }
}
