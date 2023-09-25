package org.asset;

import org.junit.Assert;
import org.junit.Test;

public class RateConversionTest_18 {
    RateConversion_18 rateConversion_18;

@Test
    public void testGetRateTimeStampCCYMatch_OK(){
    rateConversion_18=new RateConversion_18();
    rateConversion_18.putRate("EURUSD", 100100L, 1.01);
    rateConversion_18.putRate("EURUSD", 100200L, 1.02);
    rateConversion_18.putRate("EURUSD", 100500L, 1.01);
    rateConversion_18.putRate("EURUSD", 100600L, .95);
    rateConversion_18.putRate("EURUSD", 100700L, 1.07);
    Double rate=rateConversion_18.getRate2("EURUSD",100600L);
    Assert.assertEquals(.95,rate,0.0);
}

    @Test
    public void testGetRate_NoTimeStampMatch_OK(){
        rateConversion_18=new RateConversion_18();
        rateConversion_18.putRate("EURUSD", 100100L, 1.01);
        rateConversion_18.putRate("EURUSD", 100200L, 1.02);
        rateConversion_18.putRate("EURUSD", 100500L, 1.01);
        rateConversion_18.putRate("EURUSD", 100600L, .95);
        rateConversion_18.putRate("EURUSD", 100700L, 1.07);
        Double rate=rateConversion_18.getRate2("EURUSD",1007000L);
        Assert.assertEquals(1.07,rate,0.0);
    }

}
