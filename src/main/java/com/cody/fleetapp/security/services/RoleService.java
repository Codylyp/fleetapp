package com.cody.fleetapp.security.services;

import com.cody.fleetapp.models.User;
import com.cody.fleetapp.repositories.UserRepository;
import com.cody.fleetapp.security.models.Role;
import com.cody.fleetapp.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * ClassName: RoleService
 * Package: com.cody.fleetapp.security.services
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/11/7 - 23:23
 * @Version: v1.0
 **/

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    // return list of roles
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    // save new role
    public void save(Role role){
        roleRepository.save(role);
    }

    // get by id
    public Optional<Role> findById(int id){
        return roleRepository.findById(id);
    }


    // delete
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public void assignUserRole(Integer userId, Integer roleId){
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);

        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);

        userRepository.save(user);
    }

    public void unassignUserRole(Integer userId, Integer roleId){
        User user = userRepository.findById(userId).orElse(null);
        Set<Role> userRoles = user.getRoles();

        userRoles.removeIf(x -> x.getId() == roleId);
        user.setRoles(userRoles);

        userRepository.save(user);
    }

    public Set<Role> getUserRoles(User user){
        return user.getRoles();
    }

    public Set<Role> getUserNotRoles(User user){
        return roleRepository.getUserNotRoles(user.getId());
    }
    
}
