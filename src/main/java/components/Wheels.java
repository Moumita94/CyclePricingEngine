package components;

import java.util.Date;

public class Wheels extends HighLevelComponent {
    private Long spokes;
    private Long rim;
    private Long tube;
    private Long tyre;


    public Wheels(Long spokes, Long rim, Long tube, Long tyre, Date dateOFCreation) {
        this.spokes = spokes;
        this.rim = rim;
        this.tube = tube;
        this.tyre = tyre;
        this.dateOFCreation = dateOFCreation;
        basePrice = 100;
    }

    public Wheels(Date dateOFCreation) {
        this.dateOFCreation = dateOFCreation;
        basePrice = 100;
        this.spokes = 1L;
        this.rim = 1L;
        this.tube = 1L;
        this.tyre = 1L;
    }

    public double getBasePrice() {
        Long totalNumberOfParts=spokes+rim+tube+tyre;
        return basePrice*totalNumberOfParts;
    }


    public Long getSpokes() {
        return spokes;
    }

    public void setSpokes(Long spokes) {
        this.spokes = spokes;
    }

    public Long getRim() {
        return rim;
    }

    public void setRim(Long rim) {
        this.rim = rim;
    }

    public Long getTube() {
        return tube;
    }

    public void setTube(Long tube) {
        this.tube = tube;
    }

    public Long getTyre() {
        return tyre;
    }

    public void setTyre(Long tyre) {
        this.tyre = tyre;
    }

    public Date getDateOFCreation() {
        return dateOFCreation;
    }

    public void setDateOFCreation(Date dateOFCreation) {
        this.dateOFCreation = dateOFCreation;
    }
}
