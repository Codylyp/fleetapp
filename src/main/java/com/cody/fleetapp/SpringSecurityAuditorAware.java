package com.cody.fleetapp;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * ClassName: SpringSecurityAuditorAware
 * Package: com.cody.fleetapp
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/11/4 - 15:50
 * @Version: v1.0
 **/
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return Optional.ofNullable(username).filter(s -> !s.isEmpty());
    }
}
