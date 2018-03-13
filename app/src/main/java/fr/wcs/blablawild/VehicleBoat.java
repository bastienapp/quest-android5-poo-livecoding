package fr.wcs.blablawild;

/**
 * Created by bastienwcs on 13/03/18.
 */

public class VehicleBoat extends VehicleAbstract {

    private int hours;

    public VehicleBoat(String brand, String model, int hours) {
        super(brand, model);
        this.hours = hours;
    }

    @Override
    String getDescription() {
        return getBrand() + ", " + getModel() + ", " + hours;
    }
}
