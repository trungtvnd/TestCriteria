package com.example.test_criterial1.service.impl;

import com.example.test_criterial1.model.Employee;
import com.example.test_criterial1.model.Employee_;
import com.example.test_criterial1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> findByOfficeAndTime(Long idOff, String role) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> q = cb.createQuery(Employee.class);
        Root<Employee> root = q.from(Employee.class);
        Predicate hasIdOff = cb.equal(root.get(Employee_.idOffice), idOff);
        Predicate hasRole = cb.equal(root.get(Employee_.role), role);
        Predicate condition = cb.and(hasIdOff, hasRole);
        q.select(root).where(condition);
        List<Employee> list = em.createQuery(q).getResultList();
        return list ;
    }
}
