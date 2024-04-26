package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.User;
import com.cody.fleetapp.models.User;
import com.cody.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: UserController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:20
 * @Version: v1.0
 **/

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model){

        List<User> userList = userService.getUsers();
        model.addAttribute("users", userList);

        return "User";
    }

    //Modified method to Add a new user User
    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {

        userService.save(user);

        RedirectView  redirectView= new RedirectView("/login",true);
        redir.addFlashAttribute("message","You successfully registered! You can now login");
        return redirectView;
    }

    @RequestMapping("users/findById")
    @ResponseBody
    public User findById(int id){
        return userService.findById(id);
    }

    @RequestMapping(value = "/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user){
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        userService.delete(id);
        return "redirect:/users";
    }
}
