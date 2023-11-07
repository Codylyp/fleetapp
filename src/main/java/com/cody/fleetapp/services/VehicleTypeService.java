package com.cody.fleetapp.services;

import com.cody.fleetapp.models.VehicleType;
import com.cody.fleetapp.repositories.VehicleTypeRepository;
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
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    // return list of vehicleTypes
    public List<VehicleType> getVehicleTypes(){
        return vehicleTypeRepository.findAll();
    }

    // save new vehicleType
    public void save(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }

    // get by id
    public Optional<VehicleType> findById(int id){
        return vehicleTypeRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }

}
