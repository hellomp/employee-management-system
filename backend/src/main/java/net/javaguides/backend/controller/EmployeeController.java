package net.javaguides.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.backend.exception.ResourceNotFoundException;
import net.javaguides.backend.model.Employee;
import net.javaguides.backend.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
  @Autowired
  private EmployeeRepository employeeRepository;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/employees")
  public List<Employee> getAllEmployees(){
    return employeeRepository.findAll();
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/employees")
  public Employee createEmployee(@RequestBody Employee employee){
    return employeeRepository.save(employee);
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    return ResponseEntity.ok().body(employee);
  }
}
