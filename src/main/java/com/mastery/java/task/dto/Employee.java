package com.mastery.java.task.dto;

public class Employee {

    private Long employee_id;
    private String first_name;
    private String last_name;
    private Long department_id;
    private String job_title;
    private Gender gender;
    private String date_of_birth;

    public Employee() {}

    public Employee(Long employee_id, String first_name, String last_name, Long department_id, String job_title, Gender gender, String date_of_birth) {

        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.department_id = department_id;
        this.job_title = job_title;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }
}
