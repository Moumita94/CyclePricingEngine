package pricingRate;

import java.util.Date;

public class Pricing {
// Current Inflation Rate. This is used to simulate the price change with respect to time.
    public volatile double inflationRate = 4.86;
    public Date referenceBaseDate = new Date();

    public double getInflationRate() {
        return inflationRate;
    }

    public Date getReferenceBaseDate() {
        return referenceBaseDate;
    }
}
