package com.example.horoscopegenerator.Repository;


import com.example.horoscopegenerator.Model.Horoscope;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoroscopeRepository extends JpaRepository<Horoscope, Long> {
    List<Horoscope> findByZodiacSign(String zodiacSign);
    List<Horoscope> findByDate(String date);
}