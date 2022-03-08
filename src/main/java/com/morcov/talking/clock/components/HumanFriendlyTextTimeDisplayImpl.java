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

    public void displayCurrentTime(){
        LocalTime localTime = LocalTime.now();
        displayTime(localTime);
    }

    @Override
    public void displayTime(LocalTime localTime){
        timePrinterService.populateArray();
        int hour = localTime.getHour();
        int minutes = localTime.getMinute();
        if (hour > 12){
            hour = hour - 12;
        }
        timePrinterService.printTime(hour, minutes);

    }



}
