package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
public class HomeController {
    @RequestMapping("/")
    public String Greetings(){
        return "Hello there!";
    }

//    @RequestMapping(value ="/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setId("1");
        user.setName("Pavan");
        user.setEmail("paonejogi@gmail.com");
        return user;
    }

    @GetMapping("/{id}/{id1}")
    public String userInfo(@PathVariable String id, @PathVariable("id1") String name){
        return "This is user id : " +id + " and his name is :  " + name;
    }

    @GetMapping("/reqparam")
    public String userInformation(@RequestParam String name, @RequestParam("email") String email){
        return "Name: " + name + "Email: " + email;
    }
}
