package com.foodapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String filename;
    
    private String url;
    private String altText;
    private boolean isPrimary = false;
    private LocalDateTime uploadDate = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;
}