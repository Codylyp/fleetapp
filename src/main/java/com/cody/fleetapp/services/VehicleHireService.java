package com.cody.fleetapp.services;

import com.cody.fleetapp.models.VehicleHire;
import com.cody.fleetapp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: ClientService
 * Package: com.cody.fleetapp.services
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:28
 * @Version: v1.0
 **/

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    // return list of vehicleHires
    public List<VehicleHire> getVehicleHires(){
        return vehicleHireRepository.findAll();
    }

    // save new vehicleHire
    public void save(VehicleHire vehicleHire){
        vehicleHireRepository.save(vehicleHire);
    }

    // get by id
    public Optional<VehicleHire> findById(int id){
        return vehicleHireRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }

}
