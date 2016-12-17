package security.util;

import java.time.LocalTime;

public class GreetingUser {

    private LocalTime currentTime;

    public GreetingUser() {
        currentTime = LocalTime.now();
    }

    public String getGreetingPhrase(){

        if(currentTime.isAfter(LocalTime.of(22,0))) return "Доброй ночи";
        if(currentTime.isAfter(LocalTime.of(18,0))) return "Добрый вечер";
        if(currentTime.isAfter(LocalTime.of(10,0))) return "Добрый день";
        if(currentTime.isAfter(LocalTime.of(6,0))) return "Доброе утро";
        if(currentTime.isAfter(LocalTime.of(0,0))) return "Доброй ночи";
        return null;
    }
}
