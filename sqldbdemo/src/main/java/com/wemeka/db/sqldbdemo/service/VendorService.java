package com.wemeka.db.sqldbdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wemeka.db.sqldbdemo.entities.Vendor;

import java.util.List;
import java.util.Optional;

@Component
public class VendorService {

    @Autowired
    IVendorPersistence vendor;

    public List<Vendor> readAllVendors(){
        return vendor.findAll();
    }
    
    public Vendor createVendor(Vendor vendorObj) {
        return vendor.save(vendorObj);
    }

    public List<Vendor> searchByCompanyName(String companyName) {
        return vendor.findByCompanyName(companyName);
    }

    public List<Vendor> lookUpVendorByEmail(String email){
        return vendor.lookUpVendorByEmail(email);
    }

    public Optional<Vendor> getSingleVendor(Long Id){
        return vendor.findById(Id);
    }

    public Vendor changeVendor(Vendor payload){
        Optional<Vendor> vendor_db = vendor.findById(payload.getId());
        if(!vendor_db.isPresent()){
            return new Vendor((long)0, "", "", "", "", "", "", null);
        }
        return vendor.save(payload);
    }

    
    public String deleteVendor(Long Id){
        Optional<Vendor> vendor_db = vendor.findById(Id);
        if(!vendor_db.isPresent()){
            return "Unable to delete row";
        }
        vendor.deleteById(Id);
        return "Row deleted";
    }

}
