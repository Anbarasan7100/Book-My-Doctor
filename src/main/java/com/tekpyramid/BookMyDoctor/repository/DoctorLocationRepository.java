package com.tekpyramid.BookMyDoctor.repository;

import com.tekpyramid.BookMyDoctor.entity.DoctorLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorLocationRepository extends JpaRepository<DoctorLocation,Integer> {
}
