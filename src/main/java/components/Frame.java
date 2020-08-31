package components;

import java.util.Date;

public class Frame extends HighLevelComponent {
    private Type type;

    public Frame(Type type, Date dateOFCreation) {
        this.type = type;
        this.basePrice=type.getPrice();
        this.dateOFCreation = dateOFCreation;
    }

    public Frame(Date dateOFCreation) {
        this.type = Type.ALUMINUM;
        this.basePrice=type.getPrice();
        this.dateOFCreation = dateOFCreation;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDateOFCreation() {
        return dateOFCreation;
    }

    public void setDateOFCreation(Date dateOFCreation) {
        this.dateOFCreation = dateOFCreation;
    }
}
