package com.tekpyramid.BookMyDoctor.service;

import com.tekpyramid.BookMyDoctor.dto.UserLoginDto;
import com.tekpyramid.BookMyDoctor.dto.UserSignUpDto;
import com.tekpyramid.BookMyDoctor.dto.UserUpdateDto;
import com.tekpyramid.BookMyDoctor.entity.User;
import com.tekpyramid.BookMyDoctor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Override
    public String userSignup(UserSignUpDto userSignUpDto) {
        if (userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()){
            throw new RuntimeException("User already registered");
        }

        User user = User.builder()
                .userName(userSignUpDto.getUserName())
                .email(userSignUpDto.getEmail())
                .password(userSignUpDto.getPassword())
                .mobileNo(userSignUpDto.getMobileNo())
                .gender(userSignUpDto.getGender())
                .age(userSignUpDto.getAge()).build();

        return "User registration Successful with ID : " + userRepository.save(user).getUserId();
    }

    @Override
    public String userLogin(UserLoginDto userLoginDto) {

        User user = userRepository.findByEmail(userLoginDto.getEmail())
                .orElseThrow(()-> new RuntimeException("User not found"));

        if(!user.getPassword().equals(userLoginDto.getPassword())){
            throw new RuntimeException("Invalid Password");
        }

        return "Login Successful " + user.getUserName();
    }

    @Override
    public String userUpdate(String email, UserUpdateDto userUpdateDto) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found"));

        user.setUserName(userUpdateDto.getUserName());
        user.setMobileNo(userUpdateDto.getMobileNo());
        user.setAge(userUpdateDto.getAge());
        user.setGender(userUpdateDto.getGender());

        userRepository.save(user);

        return "User Details updated successfully";
    }


}
