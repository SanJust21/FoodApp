package com.example.FoodApp.Service;

import com.example.FoodApp.Model.User;
import com.example.FoodApp.Model.UserRole;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(Long id);

//    public void deleteUserById(Long id);
}
