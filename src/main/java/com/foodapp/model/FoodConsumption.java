package com.foodapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "food_consumptions")
public class FoodConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;
    
    private LocalDateTime consumptionDate = LocalDateTime.now();
    private boolean hadReaction = false;
    private String reactionSeverity;
    private String notes;
}