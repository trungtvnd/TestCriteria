package com.example.test_criterial1.controller;

import com.example.test_criterial1.model.Office_;
import com.example.test_criterial1.service.OfficerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("office")
public class OfficeController {
    @Autowired
    private  OfficerService officerService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(officerService.getListAll(),HttpStatus.OK);
    }

    @GetMapping("/getByProvince")
    public ResponseEntity<?> getAllByProvince(){
        return new ResponseEntity<>(officerService.getListAllByProvince("Nam Dinh"),HttpStatus.OK);
    }

}
