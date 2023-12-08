package com.example.FoodApp.Controller;


import com.example.FoodApp.Model.Role;
import com.example.FoodApp.Model.User;
import com.example.FoodApp.Model.UserRole;
import com.example.FoodApp.Repository.RoleRepository;
import com.example.FoodApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    //Creating User
    @PostMapping("/Register")
    public ResponseEntity<Object> createUser(@RequestBody User user) throws Exception {
        System.out.println("............");
        System.out.println(user);

        String selectedRoleName = user.getSelectedRole();
        Role role = roleRepository.findByRoleName(selectedRoleName);
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        // Set the user roles
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);

        // Save the user using the UserService
        return ResponseEntity.ok(userService.createUser(user, userRoles));

    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return this.userService.getUser(id);
    }

//    @DeleteMapping("/{id}")
//    public void deleteUserById(@PathVariable("id") Long id){
//        this.userService.deleteUserById(id);
//    }

}
