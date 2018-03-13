package fr.wcs.blablawild;

/**
 * Created by bastienwcs on 13/03/18.
 */

public class VehicleCar extends VehicleAbstract {

    private int kilometers;

    public VehicleCar(String brand, String model, int kilometers) {
        super(brand, model);
        this.kilometers = kilometers;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    String getDescription() {
        return getBrand() + ", " + getModel() + ", " + kilometers;
    }
}
