package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.Contact;
import com.cody.fleetapp.models.Country;
import com.cody.fleetapp.models.State;
import com.cody.fleetapp.services.ContactService;
import com.cody.fleetapp.services.CountryService;
import com.cody.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: ContactController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:17
 * @Version: v1.0
 **/
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @GetMapping("/contacts")
    public String getContacts(Model model){

        List<Contact> contactList = contactService.getContacts();
        model.addAttribute("contacts", contactList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        return "Contact";
    }

    @PostMapping("/contacts/addNew")
    public String addNew(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping("contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(int id){
        return contactService.findById(id);
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        contactService.delete(id);
        return "redirect:/contacts";
    }
    
}
