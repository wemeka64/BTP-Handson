package com.wemeka.db.sqldbdemo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wemeka.db.sqldbdemo.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long> {
    
}
