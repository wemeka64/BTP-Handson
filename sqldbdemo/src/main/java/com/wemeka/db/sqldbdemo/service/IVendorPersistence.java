package com.wemeka.db.sqldbdemo.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wemeka.db.sqldbdemo.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, Long> {
    List <Vendor> findByCompanyName(String companyName);

    @Query(nativeQuery=true, 
            value="SELECT * FROM public.vendor where lower(EMAIL_ID) like %?1% " )
    List <Vendor> lookUpVendorByEmail(String email);

}
