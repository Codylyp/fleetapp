package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.*;
import com.cody.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: EmployeeController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:19
 * @Version: v1.0
 **/

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @Autowired
    private JobTitleService jobTitleService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;


    @GetMapping("/employees")
    public String getEmployees(Model model){

        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employees", employeeList);

        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypeList);

        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitleList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        return "Employee";
    }

    @PostMapping("/employees/addNew")
    public String addNew(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Optional<Employee> findById(int id){
        return employeeService.findById(id);
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeService.delete(id);
        return "redirect:/employees";
    }
    
}
