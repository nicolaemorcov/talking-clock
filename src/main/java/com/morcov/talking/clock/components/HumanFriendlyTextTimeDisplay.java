package com.morcov.talking.clock.components;

import java.time.LocalTime;

public interface HumanFriendlyTextTimeDisplay {
    void displayCurrentTime();

    void displayTime(LocalTime localTime);
}
