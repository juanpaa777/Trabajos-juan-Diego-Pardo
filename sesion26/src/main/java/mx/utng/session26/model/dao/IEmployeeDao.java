package mx.utng.session26.model.dao;

import mx.utng.session26.model.entity.Employee;
import java.util.List;

public interface IEmployeeDao {
    List<Employee> list();
    void save(Employee employee);
    Employee getById(Long id);
    void delete(Long id);
}
