package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
    private static Map<String, Long> studentVolunteerEventCount;

    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {

        studentVolunteerEventCount = attendeesMapping.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return students.stream()
                .filter(App::volunteerNotCompleted)
                .collect(Collectors.toList());
    }

    private static boolean volunteerNotCompleted(String student) {
        return studentVolunteerEventCount.getOrDefault(student, Long.valueOf(0)) < 2;

    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
