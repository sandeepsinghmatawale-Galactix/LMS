package com.kodemi.LMSInsctor.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    private String category;
    private String subCategory;
    private String level;
    private String language;
    private Boolean isFree;
    private Double price;
    private Double discount;
    private String currency;
    private Integer duration;
    private String iconUrl;

    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
}
