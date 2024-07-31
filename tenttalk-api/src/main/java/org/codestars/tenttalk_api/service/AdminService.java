package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.models.Admin;
import org.codestars.tenttalk_api.models.data.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}

