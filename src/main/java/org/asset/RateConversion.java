package org.asset;

import java.util.*;

public class RateConversion {

    //change to treemap
    private static Map<Long, RateEntity> rateEntityMap = new HashMap<Long, RateEntity>();

    public void putRate(String ccyPair, Long timestamp, Double rate) {
        RateEntity rateEntity = new RateEntity(timestamp, rate, ccyPair);
        rateEntityMap.put(timestamp, rateEntity);
    }

    public static Map<Long, RateEntity> getRateEntityMap() {
        return rateEntityMap;
    }

    //Stream api
    public Double getRate(String ccyPair, Long timeStamp) {
        List list = new ArrayList(rateEntityMap.values());
        Collections.sort(list, new RateEntityHelper());
        System.out.println("Sorted List " + list);
        for (Map.Entry entry : rateEntityMap.entrySet()) {
            RateEntity rateEntity = (RateEntity) entry.getValue();
            if (rateEntity.getTimeStamp().equals(timeStamp) && rateEntity.getCurrencyPair().equals(ccyPair)) {
                System.out.println(" rateEntity.getRate() " + rateEntity.getRate());
                return rateEntity.getRate();
            } else if (rateEntity.getTimeStamp() != timeStamp && rateEntity.getCurrencyPair() == ccyPair) {
                RateEntity tempRateEntity = (RateEntity) list.get(0);
                return tempRateEntity.getRate();
            }
        }
        return 1.0;
    }

    public static Map<Long, RateEntity> getRateMap() {
        RateEntity e1 = new RateEntity(100100l, 1.01, "EURUSD");
        RateEntity e2 = new RateEntity(100200l, 1.01, "EURUSD");
        RateEntity e3 = new RateEntity(100500l, 1.01, "EURUSD");
        RateEntity e4 = new RateEntity(100599l, 1.01, "EURUSD");
        RateEntity e5 = new RateEntity(100350l, 1.01, "EURUSD");
        rateEntityMap.put(100100l, e1);
        rateEntityMap.put(100200l, e2);
        rateEntityMap.put(100500l, e3);
        rateEntityMap.put(100599l, e4);
        rateEntityMap.put(100350l, e5);
        return rateEntityMap;
    }


}