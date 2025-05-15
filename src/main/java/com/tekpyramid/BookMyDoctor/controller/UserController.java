package com.tekpyramid.BookMyDoctor.controller;

import com.tekpyramid.BookMyDoctor.dto.UserLoginDto;
import com.tekpyramid.BookMyDoctor.dto.UserSignUpDto;
import com.tekpyramid.BookMyDoctor.response.ApiResponse;
import com.tekpyramid.BookMyDoctor.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> userSignUp(@RequestBody @Valid UserSignUpDto userSignUpDto){

        String response = userService.userSignup(userSignUpDto);

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("SignUp successfully Done");
        apiResponse.setData(response);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserLoginDto userLoginDto){
        String response = userService.userLogin(userLoginDto);

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setHttpStatus(HttpStatus.OK);
        apiResponse.setMessage("Login successfully Done");
        apiResponse.setData(response);

        return ResponseEntity.ok(apiResponse);
    }

}
