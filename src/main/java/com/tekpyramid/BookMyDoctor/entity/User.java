package com.tekpyramid.BookMyDoctor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "Please enter your name")
    @Column(nullable = false)
    private String userName;

    @Email(message = "Please enter your email")
    @Column(nullable = false,unique = true)
    private String email;

    @NotBlank(message = "Please enter the password")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "Please enter your 10-digit mobile number")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be exactly 10 digits")
    @Column(nullable = false, unique = true)
    private String mobileNo;

    @NotNull(message = "Please enter your age")
    @Column(nullable = false)
    @Positive
    private int age;

    @NotBlank(message = "Please fill your gender")
    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}
