package com.jee.core.service.model.transitionobject;

import com.jee.core.model.CalculatedData;
import com.jee.core.model.DateType;

/**
 * Created by Geoffrey on 29.06.2018
 */
public class CalculatedDataOut {

    /**
     */
    private Long id;

    /**
     */
    private String deviceType;

    /**
     */
    private DateType dateType;

    /**
     */
    private Double value;

    /**
     */
    private Long date;

    /**
     */
    public CalculatedDataOut(final CalculatedData calculatedData) {
        this.date = calculatedData.getDate();
        this.dateType = calculatedData.getDateType();
        this.deviceType = calculatedData.getDeviceType();
        this.id = calculatedData.getId();
        this.value = calculatedData.getValue();
    }

    /**
     */
    @Override
    public String toString() {
        return "CalculatedDataOut{" +
                "id=" + id +
                ", deviceType='" + deviceType + '\'' +
                ", dateType=" + dateType +
                ", value=" + value +
                ", date=" + date +
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
    public String getDeviceType() {
        return deviceType;
    }

    /**
     */
    public void setDeviceType(final String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     */
    public DateType getDateType() {
        return dateType;
    }

    /**
     */
    public void setDateType(final DateType dateType) {
        this.dateType = dateType;
    }

    /**
     */
    public Double getValue() {
        return value;
    }

    /**
     */
    public void setValue(final Double value) {
        this.value = value;
    }

    /**
     */
    public Long getDate() {
        return date;
    }

    /**
     */
    public void setDate(final Long date) {
        this.date = date;
    }
}
