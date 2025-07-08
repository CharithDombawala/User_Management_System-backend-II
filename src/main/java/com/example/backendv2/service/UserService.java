package com.example.backendv2.service;

import com.example.backendv2.dto.UserDTO;
import com.example.backendv2.model.User;
import com.example.backendv2.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers(){
        List<User> usersList = userRepo.findAll();
        return modelMapper.map(usersList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public String deleteUser(Integer userId){
//        userRepo.delete(modelMapper.map(userDTO, User.class));
//        return "Delete success";
        userRepo.deleteById(userId);
        return "User has been deleted";
    }

    public UserDTO getUserById(Integer userId){
        User user = userRepo.getUserById(userId);
        return modelMapper.map(user, UserDTO.class);
    }
}
