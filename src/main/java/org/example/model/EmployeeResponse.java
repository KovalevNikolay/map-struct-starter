package org.example.model;

import java.time.LocalDate;

public record EmployeeResponse(Long id,
                               String firstname,
                               String lastname,
                               String email,
                               LocalDate birthday) {

}
