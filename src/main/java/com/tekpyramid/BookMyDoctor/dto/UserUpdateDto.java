package com.tekpyramid.BookMyDoctor.dto;

import lombok.Data;

@Data
public class UserUpdateDto {

    private String userName;
    private String mobileNo;
    private int age;
    private String gender;

}
