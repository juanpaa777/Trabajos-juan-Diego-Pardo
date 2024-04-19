package mx.utng.session26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.Employee;
import mx.utng.session26.model.service.IEmployeeService;

@Repository
public class EmployeeDaoImpl implements IEmployeeService {

    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> list() {
        return em.createQuery("from Employee").getResultList();
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() != null && employee.getId() > 0) {
            em.merge(employee);
        } else {
            em.persist(employee);
        }
    }

    @Override
    public Employee getById(Long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public void delete(Long id) {
        Employee employee = getById(id);
        em.remove(employee);
    }
}
