package org.example.model;

import java.time.LocalDate;

public record EmployeeRequest(String firstname,
                              String lastname,
                              String email,
                              LocalDate birthday) {
}
