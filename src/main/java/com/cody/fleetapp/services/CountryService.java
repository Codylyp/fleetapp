package com.cody.fleetapp.services;

import com.cody.fleetapp.models.Country;
import com.cody.fleetapp.repositories.CountryRepository;
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
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // return list of countries
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    // save new country
    public void save(Country country){
        countryRepository.save(country);
    }

    // get by id
    public Optional<Country> findById(int id){
        return countryRepository.findById(id);
    }

    // delete country
    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
