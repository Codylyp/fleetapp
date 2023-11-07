package com.cody.fleetapp.services;

import com.cody.fleetapp.models.VehicleStatus;
import com.cody.fleetapp.repositories.VehicleStatusRepository;
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
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    // return list of vehicleStatuss
    public List<VehicleStatus> getVehicleStatuses(){
        return vehicleStatusRepository.findAll();
    }

    // save new vehicleStatus
    public void save(VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }

    // get by id
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }

}
