package mx.utng.session26.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import mx.utng.session26.model.dao.IEmployeeDao;
import mx.utng.session26.model.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    public List<Employee> list() {
        return employeeDao.list();
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return employeeDao.getById(id);
    }

    @Override
    public void delete(Long id) {
        employeeDao.delete(id);
    }
}
