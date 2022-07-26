package com.example.test_criterial1.service;

import com.example.test_criterial1.model.Office;

import java.util.List;

public interface OfficerService {

    void save(Office office);
    List<Office> getList();

    List<Office> getListAll();
    List<Office> getListAllByProvince(String province);

}
