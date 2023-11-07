package com.cody.fleetapp.services;

import com.cody.fleetapp.models.Supplier;
import com.cody.fleetapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: SupplierService
 * Package: com.cody.fleetapp.services
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:28
 * @Version: v1.0
 **/

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // return list of suppliers
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    // save new supplier
    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    // get by id
    public Optional<Supplier> findById(int id){
        return supplierRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }
    
}
