package com.tekpyramid.BookMyDoctor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @NotNull(message = "Please select the date")
    @Column(nullable = false)
    private LocalDate appointmentDate;

    @NotNull(message = "Please select the time")
    @Column(nullable = false)
    private LocalTime appointmentTime;

    @NotBlank(message = "Please enter patient name")
    @Column(nullable = false)
    private String patientName;

    @NotNull(message = "Please enter patient age")
    @Column(nullable = false)
    @Positive
    private int patientAge;

    @NotBlank(message = "Please enter patient gender")
    @Column(nullable = false)
    private String patientGender;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false)
    private Doctor doctor;

}
