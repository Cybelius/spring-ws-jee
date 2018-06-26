package com.jee.core.service.model;

import com.jee.core.model.Calculation;
import com.jee.core.service.model.calculation.CalculationOut;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Geoffrey on 26.06.2018
 */
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
}
