package com.kodemi.LMSInsctor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodemi.LMSInsctor.entites.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
