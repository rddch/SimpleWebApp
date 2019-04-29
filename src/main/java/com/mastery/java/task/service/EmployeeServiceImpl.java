package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDAO;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    @Override
    public Employee getEmployeeByIb(Long id) {
        return employeeDAO.getEmployeeByIb(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeDAO.delete(id);
    }
}
