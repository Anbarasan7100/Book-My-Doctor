package com.tekpyramid.BookMyDoctor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;


    @NotBlank(message = "Please enter your name")
    @Column(nullable = false)
    private String adminName;

    @Email(message = "Enter your valid email")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Please enter your password")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "Please enter your 10-digit mobile number")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be exactly 10 digits")
    @Column(nullable = false, unique = true)
    private String mobileNo;
}
