package com.cody.fleetapp.services;

import com.cody.fleetapp.models.Location;
import com.cody.fleetapp.repositories.LocationRepository;
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
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // return list of locations
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    // save new location
    public void save(Location location){
        locationRepository.save(location);
    }

    // get by id
    public Optional<Location> findById(int id){
        return locationRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }
}
