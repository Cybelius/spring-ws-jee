package com.jee.core.service.model.transitionobject;

import com.jee.core.service.model.EmployeeAPI;

import java.util.Collection;

/**
 * Created by Geoffrey on 28.06.2018
 */
public class EmployeeOut {

    /**
     */
    private Collection<EmployeeAPI> employees;

    /**
     */
    private EmployeeAPI employee;

    /**
     */
    public EmployeeOut() {
        super();
    }

    /**
     * @return the object to string
     */
    @Override
    public String toString() {
        return "EmployeeOut{" +
                "employees=" + employees +
                ", employee=" + employee +
                '}';
    }

    /**
     */
    public Collection<EmployeeAPI> getEmployees() {
        return employees;
    }

    /**
     */
    public void setEmployees(final Collection<EmployeeAPI> employees) {
        this.employees = employees;
    }

    /**
     */
    public EmployeeAPI getEmployee() {
        return employee;
    }

    /**
     */
    public void setEmployee(final EmployeeAPI employee) {
        this.employee = employee;
    }
}
