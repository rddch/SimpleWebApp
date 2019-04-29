package com.mastery.java.task.mapper;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployee_id(resultSet.getLong("employee_id"));
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));
        employee.setDepartment_id(resultSet.getLong("department_id"));
        employee.setJob_title(resultSet.getString("job_title"));
        employee.setGender((Gender)resultSet.getObject("gender"));
        employee.setDate_of_birth(resultSet.getString("date_of_birth"));
        return employee;
    }
}
