package com.kodemi.LMSInsctor.repos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodemi.LMSInsctor.entites.LiveSession;

public interface LiveSessionRepository extends JpaRepository<LiveSession, Long> {

	 List<LiveSession> findByIsActiveTrue();

	 List<LiveSession> findByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
	        LocalDateTime now1, LocalDateTime now2);

	 List<LiveSession> findByStartTimeGreaterThan(LocalDateTime now);

	 List<LiveSession> findByEndTimeLessThan(LocalDateTime now);
	}

