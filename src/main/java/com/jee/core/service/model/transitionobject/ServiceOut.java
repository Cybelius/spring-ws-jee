package com.jee.core.service.model.transitionobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jee.core.model.CalculatedData;
import com.jee.core.service.model.transitionobject.CalculationOut;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Geoffrey on 26.06.2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ServiceOut implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5602103536038355110L;

    /**
     */
    private CalculationOut calculation;

    /**
     */
    private Collection<CalculationOut> calculations;

    /**
     */
    private Collection<CalculatedDataOut> temperatures;

    /**
     */
    private Collection<CalculatedDataOut> humidity;

    /**
     */
    private Collection<CalculatedDataOut> co2;

    /**
     */
    private Collection<CalculatedDataOut> soundLevel;

    /**
     */
    public ServiceOut() {
        super();
    }

    /**
     */
    public CalculationOut getCalculation() {
        return calculation;
    }

    /**
     */
    public void setCalculation(final CalculationOut calculation) {
        this.calculation = calculation;
    }

    /**
     */
    public Collection<CalculationOut> getCalculations() {
        return calculations;
    }

    /**
     */
    public void setCalculations(final Collection<CalculationOut> calculations) {
        this.calculations = calculations;
    }

    /**
     */
    public Collection<CalculatedDataOut> getTemperatures() {
        return temperatures;
    }

    /**
     */
    public void setTemperatures(final Collection<CalculatedDataOut> temperatures) {
        this.temperatures = temperatures;
    }

    /**
     */
    public Collection<CalculatedDataOut> getHumidity() {
        return humidity;
    }

    /**
     */
    public void setHumidity(final Collection<CalculatedDataOut> humidity) {
        this.humidity = humidity;
    }

    /**
     */
    public Collection<CalculatedDataOut> getCo2() {
        return co2;
    }

    /**
     */
    public void setCo2(final Collection<CalculatedDataOut> co2) {
        this.co2 = co2;
    }

    /**
     */
    public Collection<CalculatedDataOut> getSoundLevel() {
        return soundLevel;
    }

    /**
     */
    public void setSoundLevel(final Collection<CalculatedDataOut> soundLevel) {
        this.soundLevel = soundLevel;
    }
}
