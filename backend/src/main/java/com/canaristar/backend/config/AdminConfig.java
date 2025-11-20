package com.canaristar.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminConfig {

    @Value("${ADMIN_CREATION_PASSWORD}")
    private String adminCreationPassword;

    public String getAdminCreationPassword() {
        return adminCreationPassword;
    }
}
