package com.wemekapractice.demo02;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
    
    @Autowired
    VendorService vendorService;
    @RequestMapping("/vendor")
    public HashMap<String, Vendor> getVendors(){
        return vendorService.readAllVendors();
    }
    
    @RequestMapping("/vendor/{vendorcode}")
    public Vendor getVendorById(@PathVariable("vendorcode") String code ) {
        return vendorService.getSingleVendorById(code);
    }

    @PostMapping("/vendor")
    public Vendor createVendor(@RequestBody Vendor myPostBody) {
        return vendorService.createVendor(myPostBody);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/changeVendor")
    public Vendor updateVendor(@RequestBody Vendor vendor){
        return vendorService.changeVendor(vendor);
    }

}
