package com.fmdev.tdd;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AlarmTest {
    @Mock
    private Sensor sensor;

    private static final double GOOD = 20.0;
    private static final double TOO_LOW = 14.0;
    private static final double TOO_HIGH = 26.0;
    private Alarm alarm;

    @Before
    public void setUp() throws Exception {
        alarm = new Alarm(sensor);
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
        given(sensor.getTirePressure()).willReturn(pressure);
        alarm.checkPressure();
    }
}