package com.example.horoscopegenerator.Controller;

import com.example.horoscopegenerator.Model.Horoscope;
import com.example.horoscopegenerator.Service.HoroscopeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horoscope")
public class HoroscopeController {

    private final HoroscopeService horoscopeService;

    public HoroscopeController(HoroscopeService horoscopeService) {
        this.horoscopeService = horoscopeService;
    }

    @GetMapping("/generate/{zodiacSign}")
    public Horoscope generateHoroscope(@PathVariable String zodiacSign) {
        return horoscopeService.generateHoroscope(zodiacSign);
    }

    @GetMapping("/sign/{zodiacSign}")
    public List<Horoscope> getHoroscopeBySign(@PathVariable String zodiacSign) {
        return horoscopeService.getHoroscopeBySign(zodiacSign);
    }

    @GetMapping("/date/{date}")
    public List<Horoscope> getHoroscopeByDate(@PathVariable String date) {
        return horoscopeService.getHoroscopeByDate(date);
    }
}