package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.Location;
import com.cody.fleetapp.models.Supplier;
import com.cody.fleetapp.models.Vehicle;
import com.cody.fleetapp.models.VehicleMovement;
import com.cody.fleetapp.services.LocationService;
import com.cody.fleetapp.services.SupplierService;
import com.cody.fleetapp.services.VehicleMovementService;
import com.cody.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: VehicleMovementController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:21
 * @Version: v1.0
 **/

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleMovementService vehicleMovementService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/vehicleMovements")
    public String getVehicleMovements(Model model){

        List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
        model.addAttribute("vehicleMovements", vehicleMovementList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        return "VehicleMovement";
    }

    @PostMapping("/vehicleMovements/addNew")
    public String addNew(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping("vehicleMovements/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(int id){
        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value = "/vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/vehicleMovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovements";
    }

}
