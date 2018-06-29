package com.jee.core.controller;

import com.jee.core.service.model.DeviceAPI;
import com.jee.core.service.model.EmployeeAPI;
import com.jee.core.service.model.transitionobject.EmployeeOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.jee.core.Application.CONSTANT_IP_WCF;

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
     * @return list of devices
     */
    @GetMapping("/devices")
    public ResponseEntity<List<DeviceAPI>> getDevices() {
        final List<DeviceAPI> devices = super.getListDevices();

        if (devices == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

//        log.info(devices.toString());

        //return the result
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    /**
     * @return list of employees
     */
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeAPI>> getEmployees() {
        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<List<EmployeeAPI>> employeesResponse =
                restTemplate.exchange(CONSTANT_IP_WCF + "/calculs/employees",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeAPI>>() {
                        }
                );

        final List<EmployeeAPI> employees = employeesResponse.getBody();

//        log.info(employees.toString());

        //return the result
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * @return list of employees
     */
    @PutMapping("/employees/employee/{id}")
    public ResponseEntity<EmployeeOut> updateEmployee(@PathVariable final Long id,
          @RequestBody @NonNull final EmployeeAPI employee) {
        log.debug("id: {}", id);

        final EmployeeOut out = new EmployeeOut();
        out.setEmployee(employee);

        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<EmployeeOut> entity = new HttpEntity<>(out, headers);

        try {
            final ResponseEntity<EmployeeOut> response =
                    restTemplate.exchange(CONSTANT_IP_WCF + "/calculs/employees/employee/" + id,
                            HttpMethod.PUT, entity, EmployeeOut.class);

//            log.info(response.toString());
        } catch (HttpClientErrorException e) {
            log.warn("HttpClientErrorException while completing connection: " + e.getMessage());
            log.warn("      Response body: " + e.getResponseBodyAsString());
        }

        //return the result
        return new ResponseEntity<>(out, HttpStatus.OK);
    }
}
