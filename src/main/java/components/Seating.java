package components;

import java.util.Date;

public class Seating extends HighLevelComponent {
    private Long saddle;
    private Long seatPost;


    public Seating(Long saddle, Long seatPost,Date dateOFCreation) {
        basePrice = 100;
        this.dateOFCreation=dateOFCreation;
        this.saddle = saddle;
        this.seatPost = seatPost;
    }

    public Seating(Date dateOFCreation) {
        basePrice = 100;
        this.dateOFCreation=dateOFCreation;
        this.saddle=1L;
        this.seatPost = 1L;
    }

    public double getBasePrice() {
        Long totalNumberOfParts=saddle+seatPost;
        return basePrice*totalNumberOfParts;
    }


    public Long getSaddle() {
        return saddle;
    }

    public void setSaddle(Long saddle) {
        this.saddle = saddle;
    }

    public Long getSeatPost() {
        return seatPost;
    }

    public void setSeatPost(Long seatPost) {
        this.seatPost = seatPost;
    }

    public Date getDateOFCreation() {
        return dateOFCreation;
    }

    public void setDateOFCreation(Date dateOFCreation) {
        this.dateOFCreation = dateOFCreation;
    }
}
