package com.morcov.talking.clock.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TalkingClockMain implements ApplicationRunner {

    public static final String TIME_FORMAT = "HH:mm";

    private final HumanFriendlyTextTimeDisplay humanFriendlyTextTimeDisplay;

    @Autowired
    public TalkingClockMain(HumanFriendlyTextTimeDisplay humanFriendlyTextTimeDisplay) {
        this.humanFriendlyTextTimeDisplay = humanFriendlyTextTimeDisplay;
    }

    public static void main(String[] args) {
        SpringApplication.run(TalkingClockMain.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        String[] sourceArgs = args.getSourceArgs();
        if (sourceArgs.length > 0) {
            LocalTime localTime = toLocalTimeFromHHMM(sourceArgs[0]);
            humanFriendlyTextTimeDisplay.displayTime(localTime);
        } else {
            humanFriendlyTextTimeDisplay.displayCurrentTime();
        }
    }

    public static LocalTime toLocalTimeFromHHMM(String timeInHHMM) {
        return LocalTime.parse(timeInHHMM, DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

}
