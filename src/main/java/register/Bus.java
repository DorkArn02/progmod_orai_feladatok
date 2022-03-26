package register;

public class Bus extends PublicVehicle {
    protected boolean electric;

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }
}
