package com.tekpyramid.BookMyDoctor.repository;

import com.tekpyramid.BookMyDoctor.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability,Integer> {
}
