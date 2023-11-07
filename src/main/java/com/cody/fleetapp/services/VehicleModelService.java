package com.cody.fleetapp.services;

import com.cody.fleetapp.models.VehicleModel;
import com.cody.fleetapp.repositories.VehicleModelRepository;
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
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    // return list of vehicleModels
    public List<VehicleModel> getVehicleModels(){
        return vehicleModelRepository.findAll();
    }

    // save new vehicleModel
    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }

    // get by id
    public Optional<VehicleModel> findById(int id){
        return vehicleModelRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }

}
