package com.example.actorfilmsecurity;

import com.example.actorfilmsecurity.Film.Film;
import org.springframework.stereotype.Component;

@Component
public class Helper {
    public static boolean ifYearLeap(int year) {
        if (year % 4 == 0 && !(year % 100 == 0) || year% 400 == 0 ) {
            return true;
        } else {
            return false;
        }
    }

}
