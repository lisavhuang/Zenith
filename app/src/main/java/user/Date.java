package user;

/**
 * Created by lisahuang on 5/8/17.
 */

public class Date {
    private int month;
    private int day;

    public Date(int month, int day){
        this.month = month;
        this.day = day;
    }
    public String toString(){
        return month + "/" + day;
    }
}
