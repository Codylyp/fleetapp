package com.cody.fleetapp.security.models;

import com.cody.fleetapp.models.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ClassName: Role
 * Package: com.cody.fleetapp.security.models
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/11/7 - 23:06
 * @Version: v1.0
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends Auditable<String> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String description;
    private String details;
}
