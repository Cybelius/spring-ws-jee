package com.jee.core.service.model;

import java.util.List;

/**
 * Created by Geoffrey on 26.06.2018
 */
public class MetricAPI {

    /**
     */
    private Long id;

    /**
     */
    private List<Integer> values;

    /**
     */
    private DeviceAPI device;

    /**
     */
    private Long date;

    /**
     */
    private Integer countValue;

    /**
     */
    private Integer type;

    /**
     */
    public MetricAPI() {
        super();
    }

    /**
     * message to build
     */
    @Override
    public String toString() {
        return "MetricAPI{" +
                "id=" + id +
                ", values=" + values +
                ", device=" + device +
                ", date=" + date +
                ", countValue=" + countValue +
                ", type=" + type +
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
    public List<Integer> getValues() {
        return values;
    }

    /**
     */
    public void setValues(final List<Integer> values) {
        this.values = values;
    }

    /**
     */
    public DeviceAPI getDevice() {
        return device;
    }

    /**
     */
    public void setDevice(final DeviceAPI device) {
        this.device = device;
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

    /**
     */
    public Integer getCountValue() {
        return countValue;
    }

    /**
     */
    public void setCountValue(final Integer countValue) {
        this.countValue = countValue;
    }

    /**
     */
    public Integer getType() {
        return type;
    }

    /**
     */
    public void setType(final Integer type) {
        this.type = type;
    }
}
