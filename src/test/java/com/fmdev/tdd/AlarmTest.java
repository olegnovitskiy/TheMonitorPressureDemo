package com.fmdev.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AlarmTest {
    private static final double GOOD = 20.0;
    private static final double TOO_LOW = 14.0;
    private static final double TOO_HIGH = 26.0;
    private Alarm alarm;
    private double pressure;

    @Before
    public void setUp() throws Exception {
        alarm = new TestableAlarm();
    }

    @Test
    public void beOffWhenPressureIsGood() {
        checkAlarmWhenPressureIs(GOOD);
        assertThat(alarm.isAlarmOn(), is(false));
    }

    @Test
    public void beOnWhenPressureIsTooLow() {
        checkAlarmWhenPressureIs(TOO_LOW);
        assertThat(alarm.isAlarmOn(), is(true));
    }
    
    @Test
    public void beOnWhenPressureIsTooHigh() {
        checkAlarmWhenPressureIs(TOO_HIGH);
        assertThat(alarm.isAlarmOn(), is(true));
    }

    private void checkAlarmWhenPressureIs(double pressure) {
        this.pressure = pressure;
        alarm.checkPressure();
    }

    private class TestableAlarm extends Alarm {
        @Override
        protected double getTirePressure() {
            return pressure;
        }
    }
}