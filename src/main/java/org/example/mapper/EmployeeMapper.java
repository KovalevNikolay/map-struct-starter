package org.example.mapper;

import org.example.model.Employee;
import org.example.model.EmployeeRequest;
import org.example.model.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    void updateFromDto(EmployeeRequest dto, @MappingTarget Employee entity);

    EmployeeResponse toDto(Employee entity);
}
