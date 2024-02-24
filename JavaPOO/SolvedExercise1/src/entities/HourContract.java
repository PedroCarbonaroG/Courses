package entities;

import java.util.Date;

public class HourContract {

    private Date date;
    private Double valuePerHour;
    private short hours;

    public HourContract() {

    }
    public HourContract(Date date, Double valuePerHour, short hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }
    public short getHours() {
        return hours;
    }
    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setHours(short hours) {
        this.hours = hours;
    }
    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Double totalValue() {
        return getHours() * getValuePerHour();
    }
}