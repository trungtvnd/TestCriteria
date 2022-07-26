package com.example.test_criterial2.specification;

import com.example.test_criterial2.model.Product;
import com.example.test_criterial2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
@RequiredArgsConstructor
public class CustomProductRepository {
    private static final Double PREMIUM_PRICE = 1000D;
    private final ProductRepository productRepository;

    public List<Product> getQueryResult(List<Filter> filters){
        if(filters.size()>0) {
            return productRepository.findAll(getSpecificationFromFilter(filters));
        }else {
            return productRepository.findAll();
        }
    }

    private Specification<Product> getSpecificationFromFilter(List<Filter> filters){
        Specification<Product> specification = where(createSpecification(filters.remove(0)));
        for (Filter input : filters) {
            specification = specification.and(createSpecification(input));
        }
        return specification;
    }

    private Specification<Product> createSpecification(Filter filter) {
        switch (filter.getOperator()) {
            case EQUALS:
                return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(filter.getField()), castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue())));
            case LIKE:
                return ((root, query, criteriaBuilder) ->
                        criteriaBuilder.like(root.get(filter.getField()), "%" + filter.getValue() + "%"));
            case GREATER_THAN:
                return ((root, query, criteriaBuilder) ->
                        criteriaBuilder.gt(root.get(filter.getField()),(Number) castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue())));
            case LESS_THAN:
                return ((root, query, criteriaBuilder) ->
                        criteriaBuilder.lt(root.get(filter.getField()), (Number) castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue())));
            case IN:
                return ((root, query, criteriaBuilder) ->
                        criteriaBuilder.in(root.get(filter.getField())).value(castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValues())));
            default:
                throw new RuntimeException();

        }
    }

    private Object castToRequiredType(Class fieldType, String value) {
        if (fieldType.isAssignableFrom(Double.class)) {
            return Double.valueOf(value);
        } else if (fieldType.isAssignableFrom(Integer.class)) {
            return Integer.valueOf(value);
        } else if (Enum.class.isAssignableFrom(fieldType)) {
            return Enum.valueOf(fieldType, value);
        }
        return null;
    }

    private Object castToRequiredType(Class fieldType, List<String> value) {
        List<Object> lists = new ArrayList<>();
        for (String s : value) {
            lists.add(castToRequiredType(fieldType, s));
        }
        return lists;
    }
}
