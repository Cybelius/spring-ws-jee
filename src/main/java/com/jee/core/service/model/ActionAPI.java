package com.jee.core.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Geoffrey on 26.06.2018
 *
 * This annotation indicate that any properties not bound in this type should be ignored.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ActionAPI {

    /**
     * id device
     */
    private Long id;

    /**
     */
    private ActionType action;

    /**
     */
    public ActionAPI() {
        super();
    }

    /**
     */
    @Override
    public String toString() {
        return "ActionAPI{" +
                "id_device=" + id +
                ", action='" + action + '\'' +
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
    public ActionType getAction() {
        return action;
    }

    /**
     */
    public void setAction(final ActionType action) {
        this.action = action;
    }
}
