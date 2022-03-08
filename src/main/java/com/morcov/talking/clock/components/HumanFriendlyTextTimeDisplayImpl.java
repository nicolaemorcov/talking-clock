package com.morcov.talking.clock.components;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;

@Component
public class HumanFriendlyTextTimeDisplayImpl implements HumanFriendlyTextTimeDisplay{

    private final TimePrinterService timePrinterService;

    @Autowired
    public HumanFriendlyTextTimeDisplayImpl(TimePrinterService timePrinterService) {
        this.timePrinterService = timePrinterService;
    }

    public String displayCurrentTime(){
        LocalTime localTime = LocalTime.now();
        return displayTime(localTime);
    }

    @Override
    public String displayTime(LocalTime localTime){
        timePrinterService.populateArray();
        int hour = localTime.getHour();
        int minutes = localTime.getMinute();
        if (hour > 12){
            hour = hour - 12;
        }
        return timePrinterService.printTime(hour, minutes);

    }



}
