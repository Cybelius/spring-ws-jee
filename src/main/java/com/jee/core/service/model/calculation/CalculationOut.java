package com.jee.core.service.model.calculation;

import com.jee.core.model.Calculation;

import java.util.List;

/**
 * Created by Geoffrey on 26.06.2018
 */
public class CalculationOut {

    /**
     */
    private Long id;

    /**
     */
    private String name;

    /**
     */
    private String description;

    /**
     */
    private List<String> results;

    /**
     */
    private Integer countValue;

    /**
     */
    private Integer type;

    /**
     * Construct the transactional object
     */
    public CalculationOut(final Calculation calculation) {
        this.id = calculation.getId();
        this.name = calculation.getName();
        this.description = calculation.getDescription();
        this.results = calculation.getResults();
        this.countValue = calculation.getCountValue();
        this.type = calculation.getType();
    }

    /**
     *
     * @return the message to build
     */
    @Override
    public String toString() {
        return "CalculationOut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", results=" + results +
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
    public String getDescription() {
        return description;
    }

    /**
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     */
    public List<String> getResults() {
        return results;
    }

    /**
     */
    public void setResults(final List<String> results) {
        this.results = results;
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

