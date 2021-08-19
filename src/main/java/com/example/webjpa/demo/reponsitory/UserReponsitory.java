package com.example.webjpa.demo.reponsitory;

import com.example.webjpa.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserReponsitory extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email = :emai1")
     public  User findByEmail(@Param("emai1")String email);

    @Query(value = "select u From User e Where  u.id = :id",nativeQuery = true)
    public List<User> getUserById(@Param("id") Integer id);


}
