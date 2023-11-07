package com.cody.fleetapp.services;

import com.cody.fleetapp.models.JobTitle;
import com.cody.fleetapp.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: ClientService
 * Package: com.cody.fleetapp.services
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:28
 * @Version: v1.0
 **/

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    // return list of jobTitles
    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }

    // save new jobTitle
    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

    // get by id
    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        jobTitleRepository.deleteById(id);
    }

}
