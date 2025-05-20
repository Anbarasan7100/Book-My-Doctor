package com.tekpyramid.BookMyDoctor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class DoctorLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    @NotBlank(message = "Please enter Hospital Name")
    @Column(nullable = false)
    private String hospitalName;

    @NotBlank(message = "Please enter street name")
    @Column(nullable = false)
    private String streetName;

    @NotBlank(message = "Please enter city name")
    @Column(nullable = false)
    private String city;

    @NotBlank(message = "Please enter state name")
    @Column(nullable = false)
    private String state;

    @NotBlank(message = "Please enter country name")
    @Column(nullable = false)
    private String country;

    @ManyToOne
    @JoinColumn(name = "doctorId", nullable = false)
    private Doctor doctor;

    @OneToMany(mappedBy = "doctorLocation", cascade = CascadeType.PERSIST)
    private List<DoctorAvailability> availabilities;

}
