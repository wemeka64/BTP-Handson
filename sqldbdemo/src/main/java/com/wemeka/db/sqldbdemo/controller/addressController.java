package com.wemeka.db.sqldbdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wemeka.db.sqldbdemo.entities.address;
import com.wemeka.db.sqldbdemo.service.addressService;

@RestController
public class addressController {

    @Autowired
    addressService addrSrvc;

    @RequestMapping("/address")
    public List<address> readAllAddress(){
        return addrSrvc.getAddress();
    }

    @PostMapping("/address")
    public address createAddress(@RequestBody address payload) {
        return addrSrvc.createAddress(payload);
    }
}
