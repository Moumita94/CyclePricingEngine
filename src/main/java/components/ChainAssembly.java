package components;

import java.util.Date;

public class ChainAssembly extends HighLevelComponent {
    private Long outerCover;
    private Long innerAttachment;
    private Long pin;
    private Long bush;
    private Long roller;

    public ChainAssembly(Date date, Long outerCover, Long innerAttachment, Long pin, Long bush, Long roller) {
        this.basePrice = 20;
        this.dateOFCreation = date;
        this.outerCover = outerCover;
        this.innerAttachment = innerAttachment;
        this.pin = pin;
        this.bush = bush;
        this.roller = roller;
    }

    public ChainAssembly(Date date) {
        basePrice = 100;
        dateOFCreation = date;
        outerCover = 1L;
        innerAttachment = 1L;
        pin = 1L;
        bush = 1L;
        roller = 1L;

    }

    public double getBasePrice() {
        Long totalNumberOfParts = outerCover + innerAttachment + pin + bush + roller;
        return basePrice * totalNumberOfParts;
    }

    public Long getOuterCover() {
        return outerCover;
    }

    public void setOuterCover(Long outerCover) {
        this.outerCover = outerCover;
    }

    public Long getInnerAttachment() {
        return innerAttachment;
    }

    public void setInnerAttachment(Long innerAttachment) {
        this.innerAttachment = innerAttachment;
    }

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    public Long getBush() {
        return bush;
    }

    public void setBush(Long bush) {
        this.bush = bush;
    }

    public Long getRoller() {
        return roller;
    }

    public void setRoller(Long roller) {
        this.roller = roller;
    }

    public Date getDateOFCreation() {
        return dateOFCreation;
    }

    public void setDateOFCreation(Date dateOFCreation) {
        super.dateOFCreation = dateOFCreation;
    }
}
