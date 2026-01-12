package com.kodemi.LMSInsctor.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodemi.LMSInsctor.entites.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByCourseId(Long courseId);

    List<Assignment> findByInstructorId(Long instructorId);
}
