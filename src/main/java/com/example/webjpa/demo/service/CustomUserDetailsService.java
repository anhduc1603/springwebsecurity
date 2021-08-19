package com.example.webjpa.demo.service;

import com.example.webjpa.demo.model.User;
import com.example.webjpa.demo.reponsitory.UserReponsitory;
import com.example.webjpa.demo.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserReponsitory userReponsitory;

    @Override
    public UserDetails loadUserByUsername(String email  ) throws UsernameNotFoundException {
        User user = userReponsitory.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }else {
            List<GrantedAuthority> granteList   = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            granteList.add(authority);
            UserDetails customUserDetails = new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), granteList);
            return customUserDetails;
        }

    }
}
