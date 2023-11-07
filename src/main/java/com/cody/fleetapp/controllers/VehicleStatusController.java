package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.Country;
import com.cody.fleetapp.models.VehicleStatus;
import com.cody.fleetapp.models.State;
import com.cody.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: VehicleStatusController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:21
 * @Version: v1.0
 **/

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicleStatuses")
    public String getVehicleStatuses(Model model){

        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();
        model.addAttribute("vehicleStatuses", vehicleStatusList);

        return "VehicleStatus";
    }

    @PostMapping("/vehicleStatuses/addNew")
    public String addNew(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping("vehicleStatuses/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusService.findById(id);
    }

    @RequestMapping(value = "/vehicleStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/vehicleStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatuses";
    }

}
