package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.Country;
import com.cody.fleetapp.models.VehicleMake;
import com.cody.fleetapp.models.State;
import com.cody.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: VehicleMakeController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:21
 * @Version: v1.0
 **/

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicleMakes")
    public String getVehicleMakes(Model model){

        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakes", vehicleMakeList);

        return "VehicleMake";
    }

    @PostMapping("/vehicleMakes/addNew")
    public String addNew(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping("vehicleMakes/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeService.findById(id);
    }

    @RequestMapping(value = "/vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value = "/vehicleMakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMakes";
    }

}
