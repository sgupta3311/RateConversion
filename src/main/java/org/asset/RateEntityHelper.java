package org.asset;

import java.util.Comparator;

public class RateEntityHelper implements Comparator<RateEntity> {
    public int compare(RateEntity o1, RateEntity o2) {
        if (o1.getRate().doubleValue() - o2.getRate().doubleValue() > 0) {
            return -1;
        } else if (o1.getRate().doubleValue() - o2.getRate().doubleValue() < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
