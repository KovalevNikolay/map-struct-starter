#### Map-Struct-starter

Пример реализации обновления данных при помощи http-метода PATCH используя библиотеку MapStruct.

Маппер:
```java
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    void updateFromDto(EmployeeRequest dto, @MappingTarget Employee entity);

    EmployeeResponse toDto(Employee entity);
}
```

Метод сервиса:

```java
public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
    return findById(id)
            .map(employee -> {
                EmployeeMapper.INSTANCE.updateFromDto(employeeRequest, employee);
                return EmployeeMapper.INSTANCE.toDto(employee);
            })
            .orElseThrow();
}
```
