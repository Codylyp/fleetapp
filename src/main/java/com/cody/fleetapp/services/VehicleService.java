package com.cody.fleetapp.services;

import com.cody.fleetapp.models.Vehicle;
import com.cody.fleetapp.models.Supplier;
import com.cody.fleetapp.models.Vehicle;
import com.cody.fleetapp.repositories.VehicleRepository;
import com.cody.fleetapp.repositories.SupplierRepository;
import com.cody.fleetapp.repositories.VehicleRepository;
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
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    // return list of vehicles
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    // save new vehicle
    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    // get by id
    public Optional<Vehicle> findById(int id){
        return vehicleRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }

}
