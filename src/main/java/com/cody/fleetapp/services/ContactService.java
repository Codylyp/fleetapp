package com.cody.fleetapp.services;

import com.cody.fleetapp.models.Contact;
import com.cody.fleetapp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: ContactService
 * Package: com.cody.fleetapp.services
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:28
 * @Version: v1.0
 **/

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // return list of contacts
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    // save new contact
    public void save(Contact contact){
        contactRepository.save(contact);
    }

    // get by id
    public Optional<Contact> findById(int id){
        return contactRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }
    
}
