package com.cody.fleetapp.services;

import com.cody.fleetapp.models.Employee;
import com.cody.fleetapp.models.Employee;
import com.cody.fleetapp.models.User;
import com.cody.fleetapp.repositories.EmployeeRepository;
import com.cody.fleetapp.repositories.EmployeeRepository;
import com.cody.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: EmployeeService
 * Package: com.cody.fleetapp.services
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:28
 * @Version: v1.0
 **/

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    // return list of employees
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    // save new employee
    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    // get by id
    public Optional<Employee> findById(int id){
        return employeeRepository.findById(id);
    }

    // get by id
    public Employee findByUsername(String un){
        return employeeRepository.findByUsername(un);
    }

    // delete
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    //Set the Username of the employee where firstname and lastname match
    public void assignUsername(int id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstnameAndLastname(
                employee.getFirstname(),
                employee.getLastname());
        employee.setUsername(user.getUsername());
        employeeRepository.save(employee);
    }

}
