package com.kodemi.LMSInsctor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodemi.LMSInsctor.service.LiveSessionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

 private final LiveSessionService liveService;

 @GetMapping("/live-courses")
 public String viewLiveCourses(Model model){

    model.addAttribute("liveNow", liveService.getLiveNow());
    model.addAttribute("upcoming", liveService.getUpcoming());
    model.addAttribute("completed", liveService.getCompleted());

    return "student-live-courses";
 }
}

