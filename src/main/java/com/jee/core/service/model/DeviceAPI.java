package com.jee.core.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

/**
 * Created by Geoffrey on 26.06.2018
 *
 * This annotation indicate that any properties not bound in this type should be ignored.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceAPI {

    /**
     */
    private Long id;

    /**
     */
    private String addressMac;

    /**
     */
    private Collection<EmployeeAPI> employees;

    /**
     */
    private String name;

    /**
     */
    private String nameDeviceType;

    /**
     */
    private String typeDevices;

    /**
     */
    private Boolean disabled;

    /**
     */
    public DeviceAPI() {
        super();
    }

    /**
     * @return message to build
     */
    @Override
    public String toString() {
        return "DeviceAPI{" +
                "id=" + id +
                ", addressMac='" + addressMac + '\'' +
                ", employees=" + employees +
                ", name='" + name + '\'' +
                ", nameDeviceType='" + nameDeviceType + '\'' +
                ", typeDevices='" + typeDevices + '\'' +
                ", disabled=" + disabled +
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
    public String getAddressMac() {
        return addressMac;
    }

    /**
     */
    public void setAddressMac(final String addressMac) {
        this.addressMac = addressMac;
    }

    /**
     */
    public Collection<EmployeeAPI> getEmployees() {
        return employees;
    }

    /**
     */
    public void setEmployees(final Collection<EmployeeAPI> employees) {
        this.employees = employees;
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
    public String getNameDeviceType() {
        return nameDeviceType;
    }

    /**
     */
    public void setNameDeviceType(final String nameDeviceType) {
        this.nameDeviceType = nameDeviceType;
    }

    /**
     */
    public String getTypeDevices() {
        return typeDevices;
    }

    /**
     */
    public void setTypeDevices(final String typeDevices) {
        this.typeDevices = typeDevices;
    }

    /**
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     */
    public void setDisabled(final Boolean disabled) {
        this.disabled = disabled;
    }
}
