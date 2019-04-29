package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeDAO {

    //create
    void add(Employee employee);

    //read
    Employee getEmployeeByIb(Long id);

    List<Employee> findAll();

    //update
    void update(Employee employee);

    //delete
    void delete(Long id);
}
