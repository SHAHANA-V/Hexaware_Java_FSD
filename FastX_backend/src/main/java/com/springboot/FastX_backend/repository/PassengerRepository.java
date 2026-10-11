package com.springboot.FastX_backend.repository;

import com.springboot.FastX_backend.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
