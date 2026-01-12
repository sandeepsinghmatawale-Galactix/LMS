package com.kodemi.LMSInsctor.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodemi.LMSInsctor.entites.LiveSession;
import com.kodemi.LMSInsctor.repos.LiveSessionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LiveSessionService {

 private final LiveSessionRepository repo;

 public List<LiveSession> getLiveNow() {
     LocalDateTime now = LocalDateTime.now();
     return repo.findByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(now, now);
 }

 public List<LiveSession> getUpcoming() {
     return repo.findByStartTimeGreaterThan(LocalDateTime.now());
 }

 public List<LiveSession> getCompleted() {
     return repo.findByEndTimeLessThan(LocalDateTime.now());
 }
}

