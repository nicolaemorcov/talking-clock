package com.morcov.talking.clock.components;

public interface TimePrinterService {
    void populateArray();

    String printTime(int hour, int minutes);
}
