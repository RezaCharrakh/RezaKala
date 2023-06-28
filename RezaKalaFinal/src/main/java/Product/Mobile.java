package Product;

import Enum.Os;
import Users.Seller;
public class Mobile extends Digital {
    //---------------(Fields)---------------
    private int SimcardNumber;
    private int CameraPixel;

    @Override
    public String toString() {
        return super.toString() +
                "SimcardNumber: " + SimcardNumber + '\n' +
                "CameraPixel: " + CameraPixel + '\n';
    }

    //---------------(Constructor)---------------
    public Mobile(String name, String brand, int price, boolean inStock, String info, int ramMemory, Os operatingSystem,
                  double weight, double length, double width, double height, int simcardNumber, int cameraPixel, Seller seller) {
        super(name, brand, price, inStock, info, ramMemory, operatingSystem, weight, length, width, height, seller, "Mobile");
        setSimcardNumber(simcardNumber);
        setCameraPixel(cameraPixel);
    }

    //---------------(Setters & Getters)---------------
    public int getSimcardNumber() {
        return SimcardNumber;
    }

    public void setSimcardNumber(int simcard) {
        SimcardNumber = simcard;
    }

    public int getCameraPixel() {
        return CameraPixel;
    }

    public void setCameraPixel(int cameraPixel) {
        CameraPixel = cameraPixel;
    }

}
