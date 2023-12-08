package com.example.FoodApp.Repository;

import com.example.FoodApp.Model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByPhoneNo(String phoneNo);

    @EntityGraph(attributePaths = "userRoles")
    @Query("SELECT u FROM User u WHERE u.id = :id")
    public User findByIdWithRoles(@Param("id") Long id);

//    public User deleteByUserId(Long id);
}
