package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/employees")
    public String getAllEmployee(Model model) {
        model.addAttribute("employee", employeeService.findAll());
        return "employeesList";
    }

    @GetMapping("/employee/{id}")
    public String findEmployeeByIb(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeByIb(id));
        return "showEmployee";
    }

    @GetMapping("/employee2/{id}")
    public @ResponseBody Employee findEmployeeByIb2(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeByIb(id));
        return employeeService.getEmployeeByIb(id);
    }

    @GetMapping("/addEmployee")
    public String createEmployeesPage() {
        return "createEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee")Employee employee) {
        employeeService.add(employee);
        return "redirect:/employees";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee")Employee employee) {
        employeeService.update(employee);
        return "redirect:/employee/" + employee.getEmployeeId();
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeByIb(id));
        return "editEmployee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
