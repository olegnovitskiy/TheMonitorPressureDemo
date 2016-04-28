package com.fmdev.tdd;

public class Alarm {
    private static final double LowPressureTreshold = 17;
    private static final double HighPressureTreshold = 21;
    private Sensor sensor = new Sensor();
    private boolean alarmOn = false;

    public void checkPressure() {
        double psiPressureValue = sensor.getTirePressure();

        if (psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
