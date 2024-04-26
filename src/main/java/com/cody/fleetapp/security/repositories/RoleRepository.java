package com.cody.fleetapp.security.repositories;

import com.cody.fleetapp.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * ClassName: RoleRepository
 * Package: com.cody.fleetapp.security.repositories
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/11/7 - 23:22
 * @Version: v1.0
 **/

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(
            value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id FROM user_role WHERE user_id = ?1)",
            nativeQuery = true
    )
    Set<Role> getUserNotRoles(Integer userId);

}
