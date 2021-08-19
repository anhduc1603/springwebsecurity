package com.example.webjpa.demo;

import com.example.webjpa.demo.model.User;
import com.example.webjpa.demo.reponsitory.UserReponsitory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserReponsitoryTest {
    @Autowired
    private UserReponsitory userReponsitory;

    @Autowired
    private TestEntityManager testEntityManager;

//    @Test
//    public void testCrateUser(){
//        User user = new User();
//        user.setFullName("Trang");
//        user.setEmail("TT@gmail.com");
//        user.setPassword("2222");
//        User savedUser = userReponsitory.save(user);
//        User exitsUser = testEntityManager.find(User.class,savedUser.getId());
//        assert(exitsUser.getEmail()).equals(user.getEmail());
//
//    }
    @Test
    public void TestFindUserByEmail(){
        String email = "haanhduc@gmail.com";
        User user = userReponsitory.findByEmail(email);
        Assert.notNull(user);
    }
}
