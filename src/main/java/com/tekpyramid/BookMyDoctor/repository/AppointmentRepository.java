package com.tekpyramid.BookMyDoctor.repository;

import com.tekpyramid.BookMyDoctor.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
