package com.cody.fleetapp.services;

import com.cody.fleetapp.models.State;
import com.cody.fleetapp.repositories.StateRepository;
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
public class StateService {
    
    @Autowired
    private StateRepository stateRepository;

    // return list of states
    public List<State> getStates(){
        return stateRepository.findAll();
    }

    // save new state
    public void save(State state){
        stateRepository.save(state);
    }

    // get by id
    public Optional<State> findById(int id){
        return stateRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
    
}
