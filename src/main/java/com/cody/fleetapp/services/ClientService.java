package com.cody.fleetapp.services;

import com.cody.fleetapp.models.Client;
import com.cody.fleetapp.repositories.ClientRepository;
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
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // return list of clients
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    // save new client
    public void save(Client client){
        clientRepository.save(client);
    }

    // get by id
    public Optional<Client> findById(int id){
        return clientRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

}
