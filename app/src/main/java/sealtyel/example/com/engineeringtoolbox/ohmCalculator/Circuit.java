package sealtyel.example.com.engineeringtoolbox.ohmCalculator;

/**
 * Created by Sealtyel on 17/nov/2014.
 */
public class Circuit
{
    private double current=0;
    private double voltage=0;
    private double resistance=0;
    private double power=0;



    public double getCurrent() {
        return current;
    }

    public double getCurrent(double v, double r)
    {
        current=v/r;
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getVoltage(double r, double i)
    {
        voltage=i*r;
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getResistance() {
        return resistance;
    }

    public double getResistance(double i,double v)
    {
        resistance=v/i;
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Circuit{" +
                "current=" + current +
                ", voltage=" + voltage +
                ", resistance=" + resistance +
                ", power=" + power +
                '}';
    }
}
