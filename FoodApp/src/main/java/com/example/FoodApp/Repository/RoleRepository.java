package com.example.FoodApp.Repository;

import com.example.FoodApp.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String selectedRoleName);
}
