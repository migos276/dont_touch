package com.foodapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String quantity;
    private String unit;
    private String allergenRisk = "Low";
    private String nutritionalValue;
    
    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;
}