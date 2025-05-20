package com.tekpyramid.BookMyDoctor.service;

import com.tekpyramid.BookMyDoctor.dto.DoctorAvailabilityDto;
import com.tekpyramid.BookMyDoctor.dto.DoctorLocationDto;
import com.tekpyramid.BookMyDoctor.dto.DoctorLoginDto;
import com.tekpyramid.BookMyDoctor.dto.DoctorSignUpDto;
import com.tekpyramid.BookMyDoctor.entity.Doctor;
import com.tekpyramid.BookMyDoctor.entity.DoctorAvailability;
import com.tekpyramid.BookMyDoctor.entity.DoctorLocation;
import com.tekpyramid.BookMyDoctor.repository.DoctorLocationRepository;
import com.tekpyramid.BookMyDoctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorLocationRepository doctorLocationRepository;

    @Override
    public String doctorLogin(DoctorLoginDto doctorLoginDto) {
        Doctor doctor = doctorRepository.findByEmail(doctorLoginDto.getEmail())
                .orElseThrow(()-> new RuntimeException("Doctor not found"));

        if(!doctor.getPassword().equals(doctorLoginDto.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return "Login successful " + doctor.getDoctorName();
    }

    @Override
    @Transactional
    public String doctorSignup(DoctorSignUpDto doctorSignUpDto) {
        if(doctorRepository.findByEmail(doctorSignUpDto.getEmail()).isPresent()){
            throw new RuntimeException("Doctor already registered");
        }

        Doctor doctor = Doctor.builder()
                .doctorName(doctorSignUpDto.getDoctorName())
                .email(doctorSignUpDto.getEmail())
                .password(doctorSignUpDto.getPassword())
                .mobileNo(doctorSignUpDto.getMobileNo())
                .gender(doctorSignUpDto.getGender())
                .age(doctorSignUpDto.getAge())
                .specialist(doctorSignUpDto.getSpecialist())
                .rating(doctorSignUpDto.getRating())
                .build();

        List<DoctorLocation> doctorLocations = new ArrayList<>();
        for (DoctorLocationDto locationDto : doctorSignUpDto.getDoctorLocations()) {
            DoctorLocation location = new DoctorLocation();
            location.setHospitalName(locationDto.getHospitalName());
            location.setStreetName(locationDto.getStreetName());
            location.setCity(locationDto.getCity());
            location.setState(locationDto.getState());
            location.setCountry(locationDto.getCountry());

            List<DoctorAvailability> availabilityList=new ArrayList<>();
            for (DoctorAvailabilityDto availabilityDto : locationDto.getAvailabilities()) {
                DoctorAvailability availability = new DoctorAvailability();
                availability.setDayOfWeek(availabilityDto.getDayOfWeek());
                availability.setStartTime(availabilityDto.getStartTime());
                availability.setEndTime(availabilityDto.getEndTime());
                availability.setDoctorLocation(location);
                availabilityList.add(availability);
            }
            location.setAvailabilities(availabilityList);

            doctorLocations.add(location);
        }

        doctor.setDoctorLocations(doctorLocations);

        return "Doctor Registration successful " + doctorRepository.save(doctor).getDoctorId();
    }

}
