package com.example.test_criterial1.controller;

import com.example.test_criterial1.filter.Filter;
import com.example.test_criterial1.model.Category;
import com.example.test_criterial1.repository.CustomProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private CustomProductRepository repository;

    @PostMapping("/getLowRangeProducts")
    public ResponseEntity<?> getLowRangeProducts(@RequestBody List<Category> list){
        return ResponseEntity.ok(repository.getLowRangeProducts(list));
    }
//    @PostMapping("/getPremiumProducts")
//    public ResponseEntity<?> getPremiumProducts(@RequestBody List<Category> list){
//        return ResponseEntity.ok(repository.getPremiumProducts(list));
//    }
//    @PostMapping("/getPremiumProducts")
//    public ResponseEntity<?> getPremiumProducts(@RequestParam("name") String name,@RequestBody List<Category> list){
//        return ResponseEntity.ok(repository.getPremiumProducts(name, list));
//    }
    @PostMapping("/getQueryResult")
    public ResponseEntity<?> getQueryResult(@RequestBody List<Filter> filters){
        return ResponseEntity.ok(repository.getQueryResult(filters));
    }
}
