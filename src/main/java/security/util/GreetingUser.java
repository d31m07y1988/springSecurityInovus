package security.util;

import java.time.LocalTime;

public class GreetingUser {

    private LocalTime currentTime = LocalTime.now();

    public GreetingUser() {
    }

    public String getGreetingPhrase(){

        if(betweenTime(6,10)) return "Доброе утро";
        if(betweenTime(10,18)) return "Добрый день";
        if(betweenTime(18,22)) return "Добрый вечер";
        if(betweenTime(22,6)) return "Доброй ночи";
        return null;
    }

    private boolean betweenTime(int after, int before){
        return currentTime.isAfter(LocalTime.of(after,0)) && currentTime.isBefore(LocalTime.of(before,0));
    }
}
