package com.jee.core.controller;

import com.jee.core.model.Calculation;
import com.jee.core.service.model.ActionAPI;
import com.jee.core.service.model.DeviceAPI;
import com.jee.core.service.model.MetricAPI;
import com.jee.core.service.model.ServiceOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Geoffrey on 26.06.2018
 */
@RestController
@RequestMapping("/mobile-transaction")
public class MobileTransactionController extends AbstractController {

    /**
     */
    private static final Logger log = LoggerFactory.getLogger(MobileTransactionController.class);

    /**
     * get list of devices from .NET platform
     * return to String json
     */
    @GetMapping("/devices")
    public List<DeviceAPI> getListDevices() {
        final List<DeviceAPI> devices = super.getListDevices();

        log.info(devices.toString());

        //return the result
        return devices;
    }

    /**
     * get latest metrics by devices
     * @return a list of metrics by devices
     */
    @GetMapping("/devices/{id}/metrics")
    public List<MetricAPI> getLatestMetricsByDevice(@PathVariable @NotNull final Long id) {
        log.debug("id: {}", id);

        final List<MetricAPI> metricbydevices = super.getMetricsByDevices(id);

        if (metricbydevices == null) {
            throw new InternalError("no metrics found");
        }

        //return the result
        return metricbydevices;
    }

    /**
     *
     * @return the collection of calculated metrics from database
     */
    @GetMapping("/calculated-metrics")
    public ResponseEntity<ServiceOut> getCalculatedMetrics() {



        return null;
    }

    /**
     * get the json parameter from call and send to WCF server
     *
     * @param action the action to send
     */
    @PostMapping("/action")
    public void requestDeviceAction(@RequestBody final ActionAPI action) {
        log.info("action: {}", action);

        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<ActionAPI> entity = new HttpEntity<>(action, headers);

        try {
            // send request and parse result
            final ResponseEntity<ActionAPI> response = restTemplate
                    .exchange("http://wcfwebservice.azurewebsites.net/Service.svc/devices/device/" + action.getId_device() + "/command",
                            HttpMethod.POST, entity, ActionAPI.class);

            log.info(response.toString());
        } catch (HttpClientErrorException e) {
            log.warn("HttpClientErrorException while completing connection: " + e.getMessage());
            log.warn("      Response body: " + e.getResponseBodyAsString());
        }
    }
}
