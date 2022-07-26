package com.example.test_criterial2.controller;

import com.example.test_criterial2.specification.CustomProductRepository;
import com.example.test_criterial2.specification.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private CustomProductRepository repository;

    @PostMapping("/getQueryResult")
    public ResponseEntity<?> search(@RequestBody  List<Filter> filter){
        return ResponseEntity.ok(repository.getQueryResult(filter));
    }
}
