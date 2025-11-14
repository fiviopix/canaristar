package com.canaristar.backend.service.otp;

import com.canaristar.backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OtpService {

    private final Map<String, String> emailOtpStorage = new HashMap<>();
    private final Map<String, User> unverifiedUsers = new HashMap<>();
    private final Map<String, String> tempPasswordStorage = new HashMap<>();

    public void saveOtp(String email, String otp) {
        emailOtpStorage.put(email, otp);
    }

    public String getOtp(String email) {
        return emailOtpStorage.get(email);
    }

    public void removeOtp(String email) {
        emailOtpStorage.remove(email);
    }

    public void saveUnverifiedUser(String email, User user) {
        unverifiedUsers.put(email, user);
    }

    public User getUnverifiedUser(String email) {
        return unverifiedUsers.get(email);
    }

    public void removeUnverifiedUser(String email) {
        unverifiedUsers.remove(email);
    }

    public void setTempPassword(String email, String password) {
        tempPasswordStorage.put(email, password);
    }

    public String getTempPassword(String email) {
        return tempPasswordStorage.get(email);
    }

    public void removeTempPassword(String email) {
        tempPasswordStorage.remove(email);
    }
}
