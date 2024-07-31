package org.codestars.tenttalk_api.controllers;

import org.codestars.tenttalk_api.models.Admin;
import org.codestars.tenttalk_api.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin loginRequest) {
        Admin admin = adminService.findByEmail(loginRequest.getEmail());
        if (admin != null && admin.getPassword().equals(loginRequest.getPassword())) {
            return admin;
        } else {
            return null;  // Failed login
        }
    }
}


