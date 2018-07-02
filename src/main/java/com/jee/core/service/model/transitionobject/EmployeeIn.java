package com.jee.core.service.model.transitionobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Geoffrey on 02.07.2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeIn {

    /**
     */
    private String email;

    /**
     */
    private String password;

    /**
     */
    private Boolean isAdmin;

    /**
     */
    public EmployeeIn() {
        super();
    }

    /**
     */
    @Override
    public String toString() {
        return "EmployeeIn{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    /**
     */
    public String getEmail() {
        return email;
    }

    /**
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     */
    public String getPassword() {
        return password;
    }

    /**
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     */
    public Boolean getAdmin() {
        return isAdmin;
    }

    /**
     */
    public void setAdmin(final Boolean admin) {
        isAdmin = admin;
    }
}
