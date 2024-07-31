package org.codestars.tenttalk_api.models.data;

import org.codestars.tenttalk_api.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
}

