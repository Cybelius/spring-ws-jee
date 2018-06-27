package com.jee.core.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Geoffrey on 27.06.2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class EmployeeAPI {

    /**
     */
    private Long id;

    /**
     */
    private String devices;

    /**
     */
    private String lastName;

    /**
     */
    private String name;

    /**
     */
    public EmployeeAPI() {
        super();
    }

    /**
     */
    @Override
    public String toString() {
        return "EmployeeAPI{" +
                "id=" + id +
                ", devices='" + devices + '\'' +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     */
    public Long getId() {
        return id;
    }

    /**
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     */
    public String getDevices() {
        return devices;
    }

    /**
     */
    public void setDevices(final String devices) {
        this.devices = devices;
    }

    /**
     */
    public String getLastname() {
        return lastName;
    }

    /**
     */
    public void setLastname(final String lastName) {
        this.lastName = lastName;
    }

    /**
     */
    public String getName() {
        return name;
    }

    /**
     */
    public void setName(final String name) {
        this.name = name;
    }
}