package com.example.test_criterial1.controller;

import com.example.test_criterial1.filter.EmployeeFilterDTO;
import com.example.test_criterial1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("getListEmployee")
    public ResponseEntity<?> getListEmployee(@RequestBody EmployeeFilterDTO employeeFilter){
        Long id = employeeFilter.getIdOff();
        String  role = employeeFilter.getRole();
        return ResponseEntity.ok(employeeService.findByOfficeAndTime(id, role));
    }
}
