package com.fmdev.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AlarmTest {
    private Alarm alarm;

    @Before
    public void setUp() throws Exception {
        alarm = new Alarm();
    }

    @Test
    public void beOffWhenPressureIsGood() {
        alarm.checkPressure();
        assertThat(alarm.isAlarmOn(), is(false));
    }
}