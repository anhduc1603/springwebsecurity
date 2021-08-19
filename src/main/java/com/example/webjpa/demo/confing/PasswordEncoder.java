package com.example.webjpa.demo.confing;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String rawPassword = "meo2";
//        String encodePassword =encoder.encode(rawPassword);
//        System.out.println(encodePassword);

        boolean isPasswordMatches = encoder.matches(
                "123456",
                "$2a$10$wPJpxgMjJ/r2jK5XN5006.wjP.JqSxmSYcY28MeBf8GVQJko3sUuu"
        );


        if (isPasswordMatches) { // correct password
            System.out.println("Dung");
        } else { // Wrong Password
            System.out.println("Sai");
        }
    }
}
