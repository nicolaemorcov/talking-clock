package com.morcov.talking.clock.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
public class TalkingClockController {

    private static final String DATE_TIME_FORMAT = "HH:mm";

    private final HumanFriendlyTextTimeDisplay humanFriendlyTextTimeDisplay;

    @Autowired
    public TalkingClockController(HumanFriendlyTextTimeDisplay humanFriendlyTextTimeDisplay) {
        this.humanFriendlyTextTimeDisplay = humanFriendlyTextTimeDisplay;
    }

    @GetMapping("/talking-clock/print-time-human-friendly")
    public ResponseEntity<?> findAllLoggedInUsers(@RequestParam(value = "time", required = false) @DateTimeFormat(pattern = DATE_TIME_FORMAT ) LocalTime time) {
        if (time == null){
            String body = humanFriendlyTextTimeDisplay.displayCurrentTime();
            return ResponseEntity.status(HttpStatus.OK).body(body);
        }else {
            String body = humanFriendlyTextTimeDisplay.displayTime(time);
            return ResponseEntity.status(HttpStatus.OK).body(body);
        }
    }


}
