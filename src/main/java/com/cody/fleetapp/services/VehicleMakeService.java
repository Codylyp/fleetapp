package com.cody.fleetapp.services;

import com.cody.fleetapp.models.VehicleMake;
import com.cody.fleetapp.repositories.VehicleMakeRepository;
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
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    // return list of vehicleMakes
    public List<VehicleMake> getVehicleMakes(){
        return vehicleMakeRepository.findAll();
    }

    // save new vehicleMake
    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }

    // get by id
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
