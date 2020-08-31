package components;

import java.util.Date;

public class HandleBarWithBrakes extends HighLevelComponent {

    private Long handleBarGrip;
    private Long frontBrakes;
    private Long headTube;
    private Long shockAbsorber;

    public HandleBarWithBrakes(Date dateOFCreation, Long handleBarGrip, Long frontBrakes, Long headTube, Long shockAbsorber) {
        basePrice = 25;
        this.dateOFCreation = dateOFCreation;
        this.handleBarGrip = handleBarGrip;
        this.frontBrakes = frontBrakes;
        this.headTube = headTube;
        this.shockAbsorber = shockAbsorber;
    }

    public HandleBarWithBrakes(Date dateOFCreation) {
        this.basePrice = 100;
        this.dateOFCreation = dateOFCreation;
        handleBarGrip=1L;
        frontBrakes=1L;
        headTube=1L;
        shockAbsorber=1L;
    }

    public double getBasePrice() {
        Long totalNumberOfParts=handleBarGrip+frontBrakes+headTube+shockAbsorber;
        return basePrice*totalNumberOfParts;
    }

    public Long getHandleBarGrip() {
        return handleBarGrip;
    }

    public void setHandleBarGrip(Long handleBarGrip) {
        this.handleBarGrip = handleBarGrip;
    }

    public Long getFrontBrakes() {
        return frontBrakes;
    }

    public void setFrontBrakes(Long frontBrakes) {
        this.frontBrakes = frontBrakes;
    }

    public Long getHeadTube() {
        return headTube;
    }

    public void setHeadTube(Long headTube) {
        this.headTube = headTube;
    }

    public Long getShockAbsorber() {
        return shockAbsorber;
    }

    public void setShockAbsorber(Long shockAbsorber) {
        this.shockAbsorber = shockAbsorber;
    }

    public Date getDateOFCreation() {
        return dateOFCreation;
    }

    public void setDateOFCreation(Date dateOFCreation) {
        this.dateOFCreation = dateOFCreation;
    }
}
