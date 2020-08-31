package components;

import java.util.Date;

public class HighLevelComponent {
    double basePrice;
    Date dateOFCreation;

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Date getDateOFCreation() {
        return dateOFCreation;
    }

    public void setDateOFCreation(Date dateOFCreation) {
        this.dateOFCreation = dateOFCreation;
    }
}

