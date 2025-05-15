package com.tekpyramid.BookMyDoctor.dto;

import lombok.*;

import java.util.List;

@Data
public class DoctorLocationDto {

        private String hospitalName;
        private String streetName;
        private String city;
        private String state;
        private String country;
        private List<DoctorAvailabilityDto> availabilities;
}
