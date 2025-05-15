package com.tekpyramid.BookMyDoctor.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class DoctorAvailabilityDto {

    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
