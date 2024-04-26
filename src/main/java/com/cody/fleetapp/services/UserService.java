package com.cody.fleetapp.services;

import com.cody.fleetapp.models.User;
import com.cody.fleetapp.models.User;
import com.cody.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    // save new user
    public void save(User user){

        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    // return list of users
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // get by id
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    // delete
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
