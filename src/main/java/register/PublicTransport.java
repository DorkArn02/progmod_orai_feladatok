package register;

import java.util.ArrayList;
import java.util.List;

public class PublicTransport {
    private List<PublicVehicle> vehicles;

    public PublicTransport(){
        vehicles = new ArrayList<>();
    }

    public List<PublicVehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(PublicVehicle publicVehicle) {
        vehicles.add(publicVehicle);
    }
}
