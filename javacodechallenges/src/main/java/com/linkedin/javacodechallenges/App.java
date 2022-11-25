package com.linkedin.javacodechallenges;

import java.time.LocalDate;
import java.time.ZoneId;

public class App {
    // Create function to calculate the date that's
    // 100 days from now

    public static void main(String[] args) {
        LocalDate now = LocalDate.now(ZoneId.of("Europe/Amsterdam"));
        System.out.println("100 days from now is " + nextDate(now, 100));
    }

    public static LocalDate nextDate(LocalDate startDate, int days) {
        return startDate.plusDays(days);
    }
}
