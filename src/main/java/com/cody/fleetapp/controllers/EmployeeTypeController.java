package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.Country;
import com.cody.fleetapp.models.EmployeeType;
import com.cody.fleetapp.models.State;
import com.cody.fleetapp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: EmployeeTypeController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:19
 * @Version: v1.0
 **/

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeTypes")
    public String getEmployeeTypes(Model model){

        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypeList);

        return "EmployeeType";
    }

    @PostMapping("/employeeTypes/addNew")
    public String addNew(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping("employeeTypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(int id){
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/employeeTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }

}
