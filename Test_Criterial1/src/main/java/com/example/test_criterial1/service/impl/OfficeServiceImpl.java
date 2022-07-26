package com.example.test_criterial1.service.impl;

import com.example.test_criterial1.model.Office;
import com.example.test_criterial1.model.Office_;
import com.example.test_criterial1.repository.OfficeRepository;
import com.example.test_criterial1.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficerService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private OfficeRepository repository;

    @Override
    public void save(Office office) {
        repository.save(office);
    }

    @Override
    public List<Office> getList() {
        return repository.findAll();
    }

    @Override
    public List<Office> getListAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> q = builder.createQuery(Office.class);
        Root<Office> root = q.from(Office.class);
        q.select(root);
        TypedQuery<Office> query = em.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Office> getListAllByProvince(String province) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> q = builder.createQuery(Office.class);
        Root<Office> root = q.from(Office.class);
        q.select(root).where(builder.equal(root.get(Office_.PROVINCE), province));

        return em.createQuery(q).getResultList();
    }


}
