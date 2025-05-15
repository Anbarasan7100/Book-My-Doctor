package com.tekpyramid.BookMyDoctor.repository;

import com.tekpyramid.BookMyDoctor.dto.DoctorLoginDto;
import com.tekpyramid.BookMyDoctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    Optional<Doctor> findByEmail(String email);

}
