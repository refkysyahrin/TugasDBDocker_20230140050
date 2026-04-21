package com.praktikumDB.deployment.controller;

import com.praktikumDB.deployment.model.User;
import com.praktikumDB.deployment.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody User request){
        userService.addUser(request);
        return "user created successfully";
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "user deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User request){
        userService.updateUser(id, request);
        return "user updated successfully";
    }
}