package com.jee.core.controller;

import com.jee.core.model.DeviceType;
import com.jee.core.service.model.ActionAPI;
import com.jee.core.service.model.DeviceAPI;
import com.jee.core.service.model.MetricAPI;
import com.jee.core.service.model.transitionobject.CalculatedDataOut;
import com.jee.core.service.model.transitionobject.ServiceOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.jee.core.Application.CONSTANT_IP_WCF;

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
     */
    public MobileTransactionController() {
        super();
    }

    /**
     * get list of devices from .NET platform
     * return to String json
     */
    @GetMapping("/devices")
    public List<DeviceAPI> getListDevices() {

        //return the result
        return super.getListDevices();
    }

    /**
     * get latest metrics by devices
     *
     * @return a list of metrics by devices
     */
    @GetMapping("/devices/device/{id}")
    public DeviceAPI getDevice(@PathVariable @NotNull final Long id) {
        log.debug("id: {}", id);

        final DeviceAPI device = super.getDevice(id);

        if (device == null) {
            throw new InternalError("no device found");
        }

        //return the result
        return device;
    }

    /**
     * get latest metrics by devices
     *
     * @return a list of metrics by devices
     */
    @GetMapping("/devices/{id}/metrics")
    public List<MetricAPI> getLatestMetricsByDevice(@PathVariable @NotNull final Long id) {
        log.debug("id: {}", id);

        final List<MetricAPI> metricByDevices = super.getMetricsByDevices(id);

        if (metricByDevices == null) {
            throw new InternalError("no metrics found");
        }

        //return the result
        return metricByDevices;
    }

    /**
     * When mobile app want calculations from db web service
     *
     * @return the collection of calculated metrics from database
     */
    @GetMapping("/calculated-metrics")
    public ResponseEntity<ServiceOut> getCalculatedMetrics() {
        final ServiceOut out = super.calculationService.getCalculatedMetrics();

        if (out == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(out, HttpStatus.OK);
    }

    /**
     * When mobile app want calculations from db web service
     *
     * @return the collection of calculated metrics from database
     */
    @GetMapping("/data/temperature")
    public List<CalculatedDataOut> getDataCalculatedTemp() {
        return super.calculationService.getDataCalculatedByTemperature();
    }

    /**
     * When mobile app want calculations from db web service
     *
     * @return the collection of calculated metrics from database
     */
    @GetMapping("/data/humidity")
    public List<CalculatedDataOut> getDataCalculatedHumidity() {
        return super.calculationService.getDataCalculatedByHumidity();
    }

    /**
     * When mobile app want calculations from db web service
     *
     * @return the collection of calculated metrics from database
     */
    @GetMapping("/data/co2")
    public List<CalculatedDataOut> getDataCalculatedCo2() {
        return super.calculationService.getDataCalculatedByCo2();
    }

    /**
     * When mobile app want calculations from db web service
     *
     * @return the collection of calculated metrics from database
     */
    @GetMapping("/data/sound-level")
    public List<CalculatedDataOut> getDataCalculatedSoundLevel() {
        return super.calculationService.getDataCalculatedBySoundLevel();
    }

    /**
     *
     */
    @GetMapping(path = "/data/date-range", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CalculatedDataOut>> getDataCalculatedByDates(@RequestParam final long startDate,
            @RequestParam final long endDate, @RequestParam final DeviceType deviceType) {
        log.info("startDate: {}, endDate: {}, deviceType: {}", startDate, endDate, deviceType);

        List<CalculatedDataOut> values = super.calculationService.getDataCalculatedByDates(startDate, endDate, deviceType);

        return new ResponseEntity<>(values, HttpStatus.OK);
    }


    /**
     * get the json parameter from call and send to WCF server
     *
     * @param action the action to send
     */
    @PostMapping("/action")
    public ResponseEntity<ActionAPI> requestDeviceAction(@RequestBody @NonNull final ActionAPI action) {
        log.debug("action: {}", action);

        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<ActionAPI> entity = new HttpEntity<>(action, headers);

        try {
            // send request and parse result
            final ResponseEntity<ActionAPI> response = restTemplate
                    .exchange(CONSTANT_IP_WCF + "/calculs/device/command",
                            HttpMethod.POST, entity, ActionAPI.class);

//            log.info(response.toString());
        } catch (HttpClientErrorException e) {
            log.warn("HttpClientErrorException while completing connection: " + e.getMessage());
            log.warn("      Response body: " + e.getResponseBodyAsString());
        }

        return new ResponseEntity<>(action, HttpStatus.OK);
    }
}
