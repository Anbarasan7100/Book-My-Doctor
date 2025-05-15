package com.tekpyramid.BookMyDoctor.dto;

import lombok.*;

import java.util.List;

@Data
public class DoctorSignUpDto {

        private String doctorName;
        private String email;
        private String password;
        private String mobileNo;
        private int age;
        private String gender;
        private String specialist;
        private int rating;
        private List<DoctorLocationDto> doctorLocations;
}
