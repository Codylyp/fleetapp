package com.cody.fleetapp.services;

import com.cody.fleetapp.models.VehicleMovement;
import com.cody.fleetapp.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: VehicleMovementService
 * Package: com.cody.fleetapp.services
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:28
 * @Version: v1.0
 **/

@Service
public class VehicleMovementService {

    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    // return list of vehicleMovements
    public List<VehicleMovement> getVehicleMovements(){
        return vehicleMovementRepository.findAll();
    }

    // save new vehicleMovement
    public void save(VehicleMovement vehicleMovement){
        vehicleMovementRepository.save(vehicleMovement);
    }

    // get by id
    public Optional<VehicleMovement> findById(int id){
        return vehicleMovementRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }

}
