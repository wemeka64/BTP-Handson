package com.wemeka.db.sqldbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wemeka.db.sqldbdemo.entities.Vendor;
import com.wemeka.db.sqldbdemo.service.VendorService;

import java.util.List;
import java.util.Optional;

@RestController
public class VendorController {

    @Autowired
    VendorService vendorService;

    
    @RequestMapping("/vendor")
    public List<Vendor> getVendors(){
        return vendorService.readAllVendors();
    }
    
    @RequestMapping("/vendor/{Id}")
    public Vendor getVendorById(@PathVariable("Id") Long id ) {
        Optional<Vendor> searchResult = vendorService.getSingleVendor(id);
        if(!searchResult.isPresent()){
            return new Vendor((long)0, "", "", "", "", "", "", null);
        }
        return searchResult.get();
    }

    @PostMapping("/vendor") //This is a service endpoint
    public Vendor createVendor(@RequestBody Vendor myPostBody) {
        return vendorService.createVendor(myPostBody);
    }

    // Test using localhost:8080/vendor/search?company=SAP
    @RequestMapping("/vendor/search") //This is a service endpoint
    public List<Vendor> searchByCompany(@RequestParam String company) {
        return vendorService.searchByCompanyName(company);
    }

     // Test using localhost:8080/vendor/lookup?email=R
    @RequestMapping("/vendor/lookup") //This is a service endpoint
     public List<Vendor> searchVendorByEmail(@RequestParam String email) {
           return vendorService.lookUpVendorByEmail(email);
    }

     // Test using localhost:8080/vendor/lookup/R
     @RequestMapping("/vendor/lookup/{email}") //This is a service endpoint
     public List<Vendor> searchVendorByEmailAlt(@PathVariable("email") String email) {
           return vendorService.lookUpVendorByEmail(email);
    }



    @RequestMapping(method = RequestMethod.PUT, value = "/vendor")
    public Vendor updateVendor(@RequestBody Vendor vendor){
        return vendorService.changeVendor(vendor);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/vendor")
    public String deleteVendor(@RequestBody Long Id){
        return vendorService.deleteVendor(Id);
    }

}
