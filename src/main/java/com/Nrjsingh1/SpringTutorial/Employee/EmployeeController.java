package com.Nrjsingh1.SpringTutorial.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return  employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
}
