package com.example.demo.businessLogic;

import java.util.List;
import java.util.Random;

public class SuperInterestingEventGenerator {

    private static final Random random = new Random();

    private static final List<String> subjects = List.of(
            "A caffeinated developer",
            "An angry penguin",
            "The mysterious AI",
            "A rogue microservice",
            "Batman",
            "A confused rubber duck",
            "The intern",
            "A sentient toaster",
            "Elon Musk's Twitter bot",
            "A time-traveling programmer"
    );

    private static final List<String> verbs = List.of(
            "accidentally deployed",
            "yeeted",
            "aggressively debugged",
            "summoned",
            "rickrolled",
            "refactored",
            "dramatically deleted",
            "whispered secrets to",
            "high-fived",
            "launched into orbit"
    );

    private static final List<String> objects = List.of(
            "the production database",
            "a mass of spaghetti code",
            "the entire internet",
            "Stack Overflow",
            "a thousand unit tests",
            "the coffee machine",
            "a blockchain of memes",
            "the legacy monolith",
            "an army of null pointers",
            "the last working server"
    );

    public static String getEvent() {
        String subject = subjects.get(random.nextInt(subjects.size()));
        String verb = verbs.get(random.nextInt(verbs.size()));
        String object = objects.get(random.nextInt(objects.size()));

        return subject + " " + verb + " " + object + ".";
    }
}
