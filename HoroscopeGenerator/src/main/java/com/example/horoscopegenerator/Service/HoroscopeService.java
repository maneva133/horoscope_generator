package com.example.horoscopegenerator.Service;

import com.example.horoscopegenerator.Model.Horoscope;
import com.example.horoscopegenerator.Repository.HoroscopeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class HoroscopeService {


    private final HoroscopeRepository horoscopeRepository;

    private static final String[] ZODIAC_SIGNS = {
            "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
            "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"
    };

    private static final String[] HOROSCOPE_TEXTS = {
            "Today is a great day to try something new!",
            "Be cautious with your decisions today.",
            "Good things are coming your way.",
            "Take some time to relax and recharge.",
            "Your creativity will shine today.",
            "Unexpected opportunities may arise.",
            "Today, your fiery energy is unstoppable—take the lead but remember patience is key",
            "Ground yourself and appreciate the beauty around you—a little self-care will go a long way",
            "Your curiosity is your superpower today—dive into something new but don’t overthink",
            "Emotions are running high—lean into your nurturing side and trust your intuition",
            "Step into the spotlight and shine—your confidence will attract great opportunities",
            "Focus on the details today—your hard work will pay off in unexpected ways",
            "Balance is key—harmonize your relationships and decisions with grace",
            "Dig deep and trust your instincts—you’re uncovering something important",
            "Adventure calls—embrace spontaneity and explore new horizons",
            "Stay disciplined and focused—your efforts are building a strong foundation",
            "Innovation is your friend today—think outside the box and surprise everyone",
            "Dream big and let your imagination guide you—magic is in the air"
    };

    public HoroscopeService(HoroscopeRepository horoscopeRepository) {
        this.horoscopeRepository = horoscopeRepository;
    }

    public Horoscope generateHoroscope(String zodiacSign) {
        Horoscope horoscope = new Horoscope();
        horoscope.setZodiacSign(zodiacSign);
        horoscope.setDate(LocalDate.now().toString());
        horoscope.setDescription(getRandomHoroscopeText());
        return horoscopeRepository.save(horoscope);
    }

    public List<Horoscope> getHoroscopeBySign(String zodiacSign) {
        return horoscopeRepository.findByZodiacSign(zodiacSign);
    }

    public List<Horoscope> getHoroscopeByDate(String date) {
        return horoscopeRepository.findByDate(date);
    }

    private String getRandomHoroscopeText() {
        Random random = new Random();
        return HOROSCOPE_TEXTS[random.nextInt(HOROSCOPE_TEXTS.length)];
    }
}