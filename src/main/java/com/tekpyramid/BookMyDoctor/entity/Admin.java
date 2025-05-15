package com.tekpyramid.BookMyDoctor.entity;

import jakarta.persistence.Entity;

@Entity
public class Admin {

    private int adminId;
    private String adminName;
    private String email;
    private String password;
    private long mobileNo;
    private String role;

}
