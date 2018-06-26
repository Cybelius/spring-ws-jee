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

    private Long id_device;

    private ActionType action;

    public ActionAPI() {
        super();
    }

    @Override
    public String toString() {
        return "ActionAPI{" +
                "id_device=" + id_device +
                ", action='" + action + '\'' +
                '}';
    }

    public Long getId_device() {
        return id_device;
    }

    public void setId_device(final Long id_device) {
        this.id_device = id_device;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(final ActionType action) {
        this.action = action;
    }
}
