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

@RestController   //Tells spring this class handles REST api requests
@RequestMapping("/api/user")  //sets the base URL path for all the endpoints in this controller
@RequiredArgsConstructor    //lombok annotation to generate a constructor with the final field userService
public class UserController {  //Rest controller class

    private final UserService userService;  //Injects UserService to handle business logic. final ensures it's initialized via constructor (due to @RequiredArgsConstructor).

    @PostMapping("/signUp")  //maps HTTP POST requests to /api/user/signUp
    public ResponseEntity<?> userSignUp(@RequestBody @Valid UserSignUpDto userSignUpDto){  //accepts a JSON body mapped to UserSignUpDto, @Valid validates it and handles signup request

        String response = userService.userSignup(userSignUpDto);  //calls the userSignUp method from UserService and stores the return message

        /* Creates new ApiResponse object to wrap the result
         * Populates the api response object by:
         * Http Status : 202 Accepted
         * Set message : success message
         * Data : response from the service layer */

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("SignUp successfully Done");
        apiResponse.setData(response);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse); //sends the response with status 202 and the body containing apiResponse
    }

    @PostMapping("/login")   //maps HTTP POST requests to /api/user/login
    public ResponseEntity<?> userLogin(@RequestBody UserLoginDto userLoginDto){ //accepts a JSON body mapped to UserLoginDto
        String response = userService.userLogin(userLoginDto); //calls userLogin method in UserService

        /* Creates new ApiResponse object to wrap the result
         * Populates the api response object by:
         * Http Status : 200 OK
         * Set message : login message
         * Data : response from the service layer */

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHttpStatus(HttpStatus.OK);
        apiResponse.setMessage("Login successfully Done");
        apiResponse.setData(response);

        return ResponseEntity.ok(apiResponse); //Returns a response with status 200 and apiResponse in the body.
    }

}
