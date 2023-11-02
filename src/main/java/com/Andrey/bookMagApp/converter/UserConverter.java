package com.Andrey.bookMagApp.converter;

import com.Andrey.bookMagApp.model.User;
import com.Andrey.bookMagApp.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserConverter {
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setDiscount(user.getDiscount());
        return userDTO;
    }

    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setDiscount(userDTO.getDiscount());
        return user;
    }

    public List<UserDTO> toUserDTOList(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = toUserDTO(user);
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }


}
