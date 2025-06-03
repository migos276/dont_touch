package com.foodapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String passwordHash;
    
    private LocalDateTime dateCreated = LocalDateTime.now();
    private boolean isActive = true;
    
    @OneToMany(mappedBy = "user")
    private List<FoodConsumption> foodConsumptions;
    
    public void setPassword(String password) {
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
    }
    
    public boolean checkPassword(String password) {
        return new BCryptPasswordEncoder().matches(password, this.passwordHash);
    }
}