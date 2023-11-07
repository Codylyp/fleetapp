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
 * ClassName: VehicleController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:20
 * @Version: v1.0
 **/

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    private VehicleModelService vehicleModelService;


    @GetMapping("/vehicles")
    public String getVehicles(Model model){

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employees", employeeList);

        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakes", vehicleMakeList);

        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();
        model.addAttribute("vehicleStatuses", vehicleStatusList);

        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypeList);

        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModels", vehicleModelList);

        return "Vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNew(Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(int id){
        return vehicleService.findById(id);
    }

    @RequestMapping(value = "/vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }

}
