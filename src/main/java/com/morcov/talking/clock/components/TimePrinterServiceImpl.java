package com.morcov.talking.clock.components;

import org.springframework.stereotype.Component;

@Component
public class TimePrinterServiceImpl implements TimePrinterService{

    private String[] names = null;

    @Override
    public void populateArray(){
        names = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                "Twenty", "Twenty one", "Twenty two", "Twenty three", "Twenty four", "Twenty five",
                "Twenty six", "Twenty seven", "Twenty eight", "Twenty nine"};
    }

    @Override
    public String printTime(int hour, int minutes){
        System.out.println("\n\n"); //this will separate the time from the rest of the logs
        String midnight = "midnight";
        String hourString = ((hour == 0) ? "midnight" : names[hour]);
        if (minutes == 0){
            if (hour == 0){
                return "It's " + midnight + " 00:00";
            }else {
                return hourString + "o'clock";
            }
        }else if (minutes == 1){
            return "One minute past " + hourString;
        }else if (minutes == 59){
            return "One minute to " + hourString;
        }else if (minutes == 15){
            return "Quarter past " + hourString;
        }else if (minutes == 30){
            return "Half past " + hourString;
        }else if (minutes == 45){
            return "Quarter to " + hourString;
        }else if (minutes <= 30) {
            return names[minutes] + " minutes past " + hourString;
        } else {
            return names[60 - minutes] + " minutes to " + names[(hour % 12) + 1];
        }
    }

}
