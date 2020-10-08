package com.samsung.bankservice.controller;//package com.samsung.bankservice.controller;
//
//import com.samsung.bankservice.entity.User;
//import com.samsung.bankservice.responsitory.UserRepository;
//import com.samsung.bankservice.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping(path = "/" ,produces = "application/json")
//public class UserController {
//
////    @Autowired
////    UserService userService;
////    @Autowired
////    UserRepository userRepository;
////
////    @GetMapping
////    public List<User> getallUSer(){
////        List<User>users=userService.getAllUser();
////        return  users;
////    }
////    @GetMapping("/{id}")
////    public User getallUSer(@PathVariable long id){
////      User user=userService.getUserById(id);
////        return  user;
////    }
////
////    @PostMapping(consumes = "application/json")
////    @ResponseStatus(HttpStatus.CREATED)
////    public User saveUser(@RequestBody User user){
////        return  userRepository.save(user);
////    }
//
//
//}
