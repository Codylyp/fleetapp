package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.Country;
import com.cody.fleetapp.models.Location;
import com.cody.fleetapp.models.State;
import com.cody.fleetapp.services.CountryService;
import com.cody.fleetapp.services.LocationService;
import com.cody.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: LocationController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:20
 * @Version: v1.0
 **/

@Controller
public class LocationController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public String getLocations(Model model){

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        return "Location";
    }

    @PostMapping("/locations/addNew")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping("locations/findById")
    @ResponseBody
    public Optional<Location> findById(int id){
        return locationService.findById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        locationService.delete(id);
        return "redirect:/locations";
    }
}
