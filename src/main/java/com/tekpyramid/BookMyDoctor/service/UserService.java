package com.tekpyramid.BookMyDoctor.service;

import com.tekpyramid.BookMyDoctor.dto.UserLoginDto;
import com.tekpyramid.BookMyDoctor.dto.UserSignUpDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    String userSignup(UserSignUpDto userSignUpDto);

    String userLogin(UserLoginDto userLoginDto);
}
