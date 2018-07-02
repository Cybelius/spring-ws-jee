package com.jee.core.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Collection;

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
    private Collection<DeviceAPI> devices;

    /**
     */
    private String lastName;

    /**
     */
    private String name;

    /**
     */
    private String email;

    /**
     */
    private String password;

    /**
     */
    private Boolean isAdmin;

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
                ", devices=" + devices +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
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
    public Collection<DeviceAPI> getDevices() {
        return devices;
    }

    /**
     */
    public void setDevices(final Collection<DeviceAPI> devices) {
        this.devices = devices;
    }

    /**
     */
    public String getLastName() {
        return lastName;
    }

    /**
     */
    public void setLastName(final String lastName) {
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

    /**
     */
    public String getEmail() {
        return email;
    }

    /**
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     */
    public String getPassword() {
        return password;
    }

    /**
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     */
    public Boolean getAdmin() {
        return isAdmin;
    }

    /**
     */
    public void setAdmin(final Boolean admin) {
        isAdmin = admin;
    }
}
