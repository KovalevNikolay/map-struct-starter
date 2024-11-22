package org.example.service;

import org.example.mapper.EmployeeMapper;
import org.example.model.Employee;
import org.example.model.EmployeeRequest;
import org.example.model.EmployeeResponse;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class EmployeeService {

    private final Map<Long, Employee> db = Map.of(
            1L, new Employee(1L, "Ivan", "Ivanov", "i.ivanov@mail.ru", LocalDate.now())
    );


    public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
        return findById(id)
                .map(employee -> {
                    EmployeeMapper.INSTANCE.updateFromDto(employeeRequest, employee);
                    return EmployeeMapper.INSTANCE.toDto(employee);
                })
                .orElseThrow();
    }


    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

}
