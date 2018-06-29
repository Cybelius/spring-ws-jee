package com.jee.core.model;

import javax.persistence.*;

/**
 * Created by Geoffrey on 28.06.2018
 */
@Entity
public class CalculatedData {

    /**
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     */
    private String deviceType;

    /**
     */
    @Enumerated(EnumType.STRING)
    private DateType dateType;

    /**
     */
    private Double value;

    /**
     */
    private Long date;

    /**
     */
    public CalculatedData() {
        super();
    }

    /**
     */
    @Override
    public String toString() {
        return "CalculatedData{" +
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
