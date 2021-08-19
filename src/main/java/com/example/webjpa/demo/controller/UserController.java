package com.example.webjpa.demo.controller;


import com.example.webjpa.demo.model.User;
import com.example.webjpa.demo.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserReponsitory userReponsitory;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new User());
        return "form_newuser";
    }

    @GetMapping("/login")
    public String login(Model model  ){
        return "login_form";
    }


    @PostMapping("/process_register")
    public String processRegister(User user){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodePassword = encoder.encode(user.getPassword());
//        user.setPassword(encodePassword);
          userReponsitory.saveAndFlush(user);
          return "register_success";
    }


    @GetMapping("/control")
    public String viewHomePage(Model model){
        List<User> listUser = userReponsitory.findAll();
        model.addAttribute("listUser",listUser);
        return "homepage";
    }


    @GetMapping("/showformupdate/{id}")
        public String showFormUpdate(@PathVariable(value = "id") Integer id,Model model){
        Optional<User> list = userReponsitory.findById(id);
        if(list==null){
            System.out.println("kHONG CO USER ID NAY");
        }else {
            model.addAttribute("user",list);
        }
        return "form_updateuser";

    }

    @GetMapping("/deletetbyid/{id}")
    public String deleteByID(@PathVariable(value = "id") Integer id){
          this.userReponsitory.deleteById(id);
          return "register_success";
    }


}
