package in.sp.SpRestAPI.controllers;


import in.sp.SpRestAPI.entities.User;
import in.sp.SpRestAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUserDetails(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllUserDetails() {
        return userService.getAlluser();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable int id) {
        User user = (User) userService.getUserDetails(id).orElse(null);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user) {
        User updateUser = userService.updateUserDetails(id, user);
        if (updateUser != null) {
            return ResponseEntity.ok(updateUser);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }
}
