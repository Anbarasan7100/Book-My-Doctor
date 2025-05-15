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
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @NotBlank(message = "Please enter your name")
    @Column(nullable = false)
    private String doctorName;

    @Email(message = "Please enter your email")
    @Column(nullable = false, unique = true)
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

    @NotBlank(message = "Please enter what kind of specialist you are")
    @Column(nullable = false)
    private String specialist;

    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    @NotNull
    @Column(nullable = false)
    private int rating;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "doctor_location_map",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<DoctorLocation> doctorLocations;

}
