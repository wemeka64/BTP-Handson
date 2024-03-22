package com.wemekapractice.demo02;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendorService {

    //Internal Table
    HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();

    @Autowired
    Vendor x;

    @Autowired
    Vendor y;

    @Autowired
    Vendor z;

    public HashMap<String, Vendor> readAllVendors(){
        fillVendor();
        return vendors;
    }

    public Vendor getSingleVendorById(String vendorcode) {
        fillVendor();
        return (Vendor)vendors.get(vendorcode);
    }

    public Vendor createVendor(Vendor vendor ) {
        vendor.code = "newly created";
        return vendor;
    }

    public Vendor changeVendor(Vendor vendor) {
        return vendor;
    }

    private void fillVendor() {
        vendors.put("1", x);
        vendors.put("2", y);
        vendors.put("3", z);
      }
}
