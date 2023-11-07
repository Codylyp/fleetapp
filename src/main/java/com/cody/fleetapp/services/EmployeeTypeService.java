package com.cody.fleetapp.services;

import com.cody.fleetapp.models.EmployeeType;
import com.cody.fleetapp.repositories.EmployeeTypeRepository;
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
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    // return list of employeeTypes
    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }

    // save new employeeType
    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    // get by id
    public Optional<EmployeeType> findById(int id){
        return employeeTypeRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }

}
