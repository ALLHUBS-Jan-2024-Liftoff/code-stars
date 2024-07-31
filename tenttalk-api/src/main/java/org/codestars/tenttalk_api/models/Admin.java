package org.codestars.tenttalk_api.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Admin extends User {

    @NotBlank(message = "Admin status is required")
    private String adminStatus;

    public Admin() {}


    public Admin(String email, String username, String password, String adminStatus) {
        super(email, username, password);
        this.adminStatus = adminStatus;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }
}

