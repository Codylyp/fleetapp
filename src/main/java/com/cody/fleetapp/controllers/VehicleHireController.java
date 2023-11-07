package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.Client;
import com.cody.fleetapp.models.Location;
import com.cody.fleetapp.models.Vehicle;
import com.cody.fleetapp.models.VehicleHire;
import com.cody.fleetapp.services.ClientService;
import com.cody.fleetapp.services.LocationService;
import com.cody.fleetapp.services.VehicleHireService;
import com.cody.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: VehicleHireController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:20
 * @Version: v1.0
 **/

@Controller
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/vehicleHires")
    public String getVehicleHires(Model model){

        List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
        model.addAttribute("vehicleHires", vehicleHireList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        return "VehicleHire";
    }

    @PostMapping("/vehicleHires/addNew")
    public String addNew(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping("vehicleHires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(int id){
        return vehicleHireService.findById(id);
    }

    @RequestMapping(value = "/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "/vehicleHires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleHireService.delete(id);
        return "redirect:/vehicleHires";
    }

}
