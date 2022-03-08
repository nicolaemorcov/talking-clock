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
        if (minutes == 0){
            if (hour == 0){
                return "It's midnight 00:00";
            }else {
                return names[hour] + "o'clock";

//                System.out.printf("%s o'clock\n", names[hour]);
            }
        }else if (minutes == 1){
            return "One minute past " + names[hour];
//            System.out.printf("One minute past %s\n", names[hour]);
        }else if (minutes == 59){
            return "One minute to " + names[hour];
//            System.out.printf("One minute to %s\n", names[hour]);
        }else if (minutes == 15){
            return "Quarter past " + names[hour];
//            System.out.printf("Quarter past %s\n", names[hour]);
        }else if (minutes == 30){
            return "Half past " + names[hour];
//            System.out.printf("Half past %s\n", names[hour]);
        }else if (minutes == 45){
            return "Quarter to " + names[hour];
//            System.out.printf("Quarter to %s\n", names[hour]);
        }else if (minutes <= 30) {
            return names[minutes] + " minutes past " + names[hour];
//            System.out.printf("%s minutes past %s\n", names[minutes], names[hour]);
        } else {
            return names[60 - minutes] + " minutes to " + names[(hour % 12) + 1];
//            System.out.printf("%s minutes to %s\n", names[60 - minutes],
//                    names[(hour % 12) + 1]);
        }
    }

}
