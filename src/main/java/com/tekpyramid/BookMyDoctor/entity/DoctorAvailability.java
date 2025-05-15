package com.tekpyramid.BookMyDoctor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availabilityId;

    @NotBlank(message = "Day of week is required")
    @Column(nullable = false)
    private String dayOfWeek;

    @NotNull(message = "Start time is required")
    @Column(nullable = false)
    private LocalTime startTime;

    @NotNull(message = "End time is required")
    @Column(nullable = false)
    private LocalTime endTime;

    @ManyToMany(mappedBy = "availabilities")
    private List<DoctorLocation> doctorLocations;

}
