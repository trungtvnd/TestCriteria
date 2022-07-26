package com.example.test_criterial1.service;

import com.example.test_criterial1.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    List<Employee> findByOfficeAndTime(Long idOff, String role);

}
