package com.example.horoscopegenerator.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Horoscope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zodiacSign;
    private String date;
    private String description;
}