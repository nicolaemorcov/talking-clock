package com.morcov.talking.clock.components;

import java.time.LocalTime;

public interface HumanFriendlyTextTimeDisplay {
    String displayCurrentTime();

    String displayTime(LocalTime localTime);
}
