package org.asset;

public class RateEntity {
    private Long timeStamp;
    private Double rate;
    private String currencyPair;

    public RateEntity(Long timeStamp, Double rate, String currencyPair) {
        this.timeStamp = timeStamp;
        this.rate = rate;
        this.currencyPair = currencyPair;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    @Override
    public String toString() {
        return "RateEntity{" +
                "timeStamp=" + timeStamp +
                ", rate=" + rate +
                ", currencyPair='" + currencyPair + '\'' +
                '}';
    }
}
