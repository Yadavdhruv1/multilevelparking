import java.util.Date;

public class Rate {
    int baseRate;
    int hourlyRate;

    public Rate(int base, int hourly) {
        this.baseRate = base;
        this.hourlyRate = hourly;
    }

    public double getTotal(Date in, Date out) {
        long diff = out.getTime() - in.getTime();
        long hours = (diff / (1000 * 60 * 60)) + 1;
        return baseRate + (hours * hourlyRate);
    }
}