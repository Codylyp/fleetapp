package com.cody.fleetapp.repositories;

import com.cody.fleetapp.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: ClientRepository
 * Package: com.cody.fleetapp.repositories
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 21:01
 * @Version: v1.0
 **/

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
