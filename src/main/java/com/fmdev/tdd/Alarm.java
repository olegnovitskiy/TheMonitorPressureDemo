package com.fmdev.tdd;

public class Alarm {
    private static final double LowPressureTreshold = 17;
    private static final double HighPressureTreshold = 21;
    private Sensor sensor;
    private boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void checkPressure() {
        double psiPressureValue = getTirePressure();

        if (psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue) {
            alarmOn = true;
        }
    }

    protected double getTirePressure() {
        return sensor.getTirePressure();
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
