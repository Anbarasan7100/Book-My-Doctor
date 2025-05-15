package com.tekpyramid.BookMyDoctor.controller;

import com.tekpyramid.BookMyDoctor.dto.DoctorLoginDto;
import com.tekpyramid.BookMyDoctor.dto.DoctorSignUpDto;
import com.tekpyramid.BookMyDoctor.response.ApiResponse;
import com.tekpyramid.BookMyDoctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/login")
    public ResponseEntity<?> doctorLogin(@RequestBody DoctorLoginDto doctorLoginDto){
        String response = doctorService.doctorLogin(doctorLoginDto);

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setHttpStatus(HttpStatus.OK);
        apiResponse.setMessage("Login Successful");
        apiResponse.setData(response);

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> doctorSignUp(@RequestBody DoctorSignUpDto doctorSignUpDto){
        String response = doctorService.doctorSignup(doctorSignUpDto);

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("SingUp successful");
        apiResponse.setData(response);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);
    }
}
