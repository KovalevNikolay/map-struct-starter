package org.example;

import org.example.model.EmployeeRequest;
import org.example.model.EmployeeResponse;
import org.example.service.EmployeeService;

public class Main {

    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();

        EmployeeRequest employeeRequest = new EmployeeRequest(null, null, "1231@mail.ru", null);

        EmployeeResponse updated = employeeService.update(1L, employeeRequest);

        System.out.println(updated);

    }
}