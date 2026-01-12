package com.kodemi.LMSInsctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodemi.LMSInsctor.entites.Instructor;
import com.kodemi.LMSInsctor.repos.InstructorRepository;

@Service
public class InstructorServiceImpl {
	
	@Autowired
    private InstructorRepository instructorRepository;
    
	
	
	public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id " + id));
    }

}
