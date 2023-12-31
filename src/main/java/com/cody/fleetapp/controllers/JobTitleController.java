package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.Country;
import com.cody.fleetapp.models.JobTitle;
import com.cody.fleetapp.models.State;
import com.cody.fleetapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: JobTitleController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:19
 * @Version: v1.0
 **/

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitles")
    public String getJobTitles(Model model){

        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitleList);

        return "JobTitle";
    }

    @PostMapping("/jobTitles/addNew")
    public String addNew(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping("jobTitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(int id){
        return jobTitleService.findById(id);
    }

    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        jobTitleService.delete(id);
        return "redirect:/jobTitles";
    }

}
