package com.wemeka.db.sqldbdemo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity //Tells JPA to create a database of this class
@Table(name="VENDOR")
public class Vendor {
    @Id
    @Column(nullable = false, name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long Id;
    @Column(nullable = false, name="COMPANY_NAME")
    public String companyName;
    @Column(nullable = false, name="FIRST_NAME")
    public String firstName;
    @Column(nullable = false, name="LAST_NAME")
    public String lastName;
    @Column(nullable = false, name="WEBSITE")
    public String website;
    @Column(nullable = false, name="EMAIL_ID")
    public String email;
    @Column(nullable = false, name="STATUS")
    public String status;
    @Column(nullable = false, name="GST_NO")
    public Date gstNo;

    //Foreign key relation to the address DB that was created (address.java class)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="vendor", referencedColumnName = "ID")
    private List<address> addresses = new ArrayList<>();

    //Spring boot behind the scene uses setter and getter method to generate row for the associated element
    public List<address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<address> addresses) {
        this.addresses = addresses;
    }

    public Vendor(){

    }
    
    public Vendor(long id, String companyName, String firstName, String lastName, String website, String email,
            String status, Date gstNo) {
        Id = id;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.website = website;
        this.email = email;
        this.status = status;
        this.gstNo = gstNo;
    }

    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getGstNo() {
        return gstNo;
    }
    public void setGstNo(Date gstNo) {
        this.gstNo = gstNo;
    }
    
 }
