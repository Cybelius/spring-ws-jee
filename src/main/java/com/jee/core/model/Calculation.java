package com.jee.core.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Geoffrey on 26.06.2018
 */
@Entity
public class Calculation {

    /**
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     */
    private String name;

    /**
     */
    private String description;

    /**
     */
    @ElementCollection
    private List<String> results;

    /**
     */
    public Calculation() {
    }

    /**
     */
    public Calculation(final String name, final String description, final List<String> results) {
        this.name = name;
        this.description = description;
        this.results = results;
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
     *
     * @return a build String object
     */
    @Override
    public String toString() {
        return "Calculation{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", results=" + results +
                '}';
    }
}
