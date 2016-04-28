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
        double psiPressureValue = sensor.getTirePressure();

        if (pressureIsNotGood(psiPressureValue)) {
            alarmOn = true;
        }
    }

    protected boolean pressureIsNotGood(double psiPressureValue) {
        return psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue;
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
