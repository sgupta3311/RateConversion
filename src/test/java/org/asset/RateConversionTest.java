package org.asset;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class RateConversionTest {
    private RateConversion rateConversion = null;

    @Test
    public void testPutEntityMap_size() {
        rateConversion = new RateConversion();
        rateConversion.putRate("EURUSD", 100100L, 1.01);
        rateConversion.putRate("EURUSD", 100200L, 1.02);
        rateConversion.putRate("EURUSD", 100500L, 1.01);
        rateConversion.putRate("EURUSD", 100599L, .95);
        rateConversion.putRate("EURUSD", 100350L, 1.07);
        // rateConversion.getRateEntityMap().size();
        assertEquals(5, rateConversion.getRateEntityMap().size());
    }

    @Test
    public void testGetRate_ok() {
        rateConversion = new RateConversion();
        rateConversion.putRate("EURUSD", 100100L, 1.01);
        rateConversion.putRate("EURUSD", 100200L, 1.02);
        rateConversion.putRate("EURUSD", 100500L, 1.01);
        rateConversion.putRate("EURUSD", 100599L, .95);
        rateConversion.putRate("EURUSD", 100350L, 1.07);
        double rate = rateConversion.getRate("EURUSD", 10010000L);
        assertNotNull(rate);
        assertEquals(rate, 1.01, 0.1);
        assertEquals(5, rateConversion.getRateEntityMap().size());
    }

    @Test
    public void testGetRate_max() {
        rateConversion = new RateConversion();
        rateConversion.putRate("EURUSD", 100100L, 1.01);
        rateConversion.putRate("EURUSD", 100200L, 1.02);
        rateConversion.putRate("EURUSD", 100500L, 1.01);
        rateConversion.putRate("EURUSD", 100599L, .95);
        rateConversion.putRate("EURUSD", 100350L, 1.07);
        double rate = rateConversion.getRate("EURUSD", 10010000L);
        assertNotNull(rate);
        assertEquals(rate, 1.07, 0.000);
        //assertEquals(5,rateConversion.getRateEntityMap().size());
    }

}
