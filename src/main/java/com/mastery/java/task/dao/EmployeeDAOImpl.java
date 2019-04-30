package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender,date_of_birth) VALUES (?,?,?,?,CAST(? AS gender),?)";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(),
                employee.getGender(),employee.getDateOfBirth());
    }

    @Override
    public Employee getEmployeeByIb(Long id) {
        String sql = "SELECT * FROM employee WHERE employee_id=?";
        return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=CAST(? AS gender),date_of_birth=? WHERE employee_id=?";
        jdbcTemplate.update(sql, employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGender(),employee.getDateOfBirth());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
