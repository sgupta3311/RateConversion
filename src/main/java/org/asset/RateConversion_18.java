package org.asset;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RateConversion_18 {

    //change to treemap
    private static Map<Long, RateEntity> rateEntityMap = new TreeMap<Long, RateEntity>();

    public void putRate(String ccyPair, Long timestamp, Double rate) {
        RateEntity rateEntity = new RateEntity(timestamp, rate, ccyPair);
        rateEntityMap.put(timestamp, rateEntity);
    }

    public static Map<Long, RateEntity> getRateEntityMap() {
        return rateEntityMap;
    }

    Comparator<RateEntity> rateEntityComparator = (RateEntity o1, RateEntity o2) -> {
        if ((o1.getRate() - o2.getRate() > 0)) {
            return -11;
        } else if ((o1.getRate() - o2.getRate() < 0)) {
            return 1;
        } else {
            return 0;
        }

    };

    public Double getRate2(String ccyPair, Long timeStamp) {
        List<RateEntity> list = new ArrayList(rateEntityMap.values());
        Collections.sort(list, rateEntityComparator);
        Predicate<RateEntity> rateEntityNoTimeStampMatch= rateEntity ->rateEntity.getCurrencyPair().equals(ccyPair) && rateEntity.getTimeStamp() != timeStamp;
        Optional<RateEntity> rateEntityFiltered = list.stream().filter(rateEntity -> rateEntity.getCurrencyPair().equals(ccyPair) && rateEntity.getTimeStamp().equals(timeStamp)).findFirst();
        if(rateEntityFiltered.isPresent()) {
            System.out.println(rateEntityFiltered.get().getRate());
            return rateEntityFiltered.get().getRate();
        }
        else{
            Optional<RateEntity> rateEntityVal = list.stream().filter(rateEntity -> rateEntity.getCurrencyPair().equals(ccyPair) && rateEntity.getTimeStamp() != timeStamp).findFirst();
            if(rateEntityVal.isPresent()) {
                return rateEntityVal.get().getRate();
            }
            else {
                return 0.0;
            }
        }
    }

}