//package com.example.test_criterial1.specification;
//
//import com.example.test_criterial1.model.Employee;
//import com.example.test_criterial1.model.Employee_;
//
//import java.util.function.Predicate;
//
//public final class EmployeeSpecification {
//
//    public static Specification<Employee> hasIdOffice(Long idOff){
//        return (root, query, cb) -> (Predicate) cb.equal(root.get(Employee_.ID_OFFICE), idOff);
//    }
//}
