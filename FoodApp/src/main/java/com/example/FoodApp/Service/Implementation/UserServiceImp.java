package com.example.FoodApp.Service.Implementation;

import com.example.FoodApp.Model.User;
import com.example.FoodApp.Model.UserRole;
import com.example.FoodApp.Repository.RoleRepository;
import com.example.FoodApp.Repository.UserRepository;
import com.example.FoodApp.Service.UserService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //Creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByPhoneNo(user.getPhoneNo());

        if(local!=null)
        {
            System.out.println("User Already Exists !");
            throw new Exception("User Already Exists !");
        }else{

////            for(UserRole ur:userRoles)
//            {
//                roleRepository.save(ur.getRole());
//            }
//            user.getUserRoles().addAll(userRoles);
            local =this.userRepository.save(user);
        }

        return local;
    }



    //Getting user By Id
    @Override
    public User getUser(Long id) {
        return this.userRepository.findByIdWithRoles(id);
    }

//    @Override
//    public void deleteUserById(Long id) {
//        this.userRepository.deleteByUserId(id);
//    }
}
