package com.tekpyramid.BookMyDoctor.dto;

import lombok.*;

@Data
public class UserSignUpDto {

        private String userName;
        private String email;
        private String password;
        private String mobileNo;
        private int age;
        private String gender;

}
