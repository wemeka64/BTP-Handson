package com.wemeka.db.sqldbdemo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ADDRESS")
@Data
public class address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "ID")
    private long addressId;
    @Column(name = "TYPE")
    private String addressType;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "REGION")
    private String region;
   
}
