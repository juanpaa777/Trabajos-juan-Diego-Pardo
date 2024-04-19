package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.Employee;
import java.util.List;

public interface IEmployeeService {
    List<Employee> list();
    void save(Employee employee);
    Employee getById(Long id);
    void delete(Long id);
}
