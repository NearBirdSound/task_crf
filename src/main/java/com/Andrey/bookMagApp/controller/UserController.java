package com.Andrey.bookMagApp.controller;

import com.Andrey.bookMagApp.converter.UserConverter;
import com.Andrey.bookMagApp.dto.UserDTO;
import com.Andrey.bookMagApp.model.User;
import com.Andrey.bookMagApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserConverter userConverter;
    @Autowired
    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    //Get User By Discount
    @RequestMapping(value = "/by-discount/{discount}", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> getUsersByDiscount(@PathVariable("discount") double discount) {
        return userConverter.toUserDTOList(userService.getUsersByDiscount(discount));
    }


    //CRUD Operation

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> getAllUsers() {
        return userConverter.toUserDTOList(userService.getAll());
    }

    @RequestMapping(value = "/one/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO getUserById(@PathVariable("userId") int userId) {
        return userConverter.toUserDTO(userService.getById(userId));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.add(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @RequestMapping(value = "/del/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.delete(userId);
    }
}