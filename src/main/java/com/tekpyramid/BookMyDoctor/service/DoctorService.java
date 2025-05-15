package com.tekpyramid.BookMyDoctor.service;

import com.tekpyramid.BookMyDoctor.dto.DoctorLoginDto;
import com.tekpyramid.BookMyDoctor.dto.DoctorSignUpDto;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService {

    String doctorLogin(DoctorLoginDto doctorLoginDto);

    String doctorSignup(DoctorSignUpDto doctorSignUpDto);
}
