package com.foodapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String description;
    private String cuisineType = "Pakistani";
    private Integer preparationTime;
    private String difficultyLevel;
    private Integer caloriesPerServing;
    private LocalDateTime dateAdded = LocalDateTime.now();
    
    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients;
    
    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;
    
    @OneToMany(mappedBy = "food")
    private List<FoodConsumption> consumptions;
}