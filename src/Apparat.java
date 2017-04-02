/**
 * Created by tildas on 2017-03-22.
 */
public class Apparat extends Vardesak {
    private Double inkopspris;
    private int slitage;

    public Apparat(String namn, Double inkopspris, int slitage) {
        super(namn);
        this.inkopspris = inkopspris;
        this.slitage = slitage;
    }

    public Double getVarde() {
        // 10.0 för att det ska bli Double
        return (inkopspris * (slitage/10.0));
    }

    public int getSlitage() {
        return slitage;
    }

    public String toString() {
        return "Namn: " + this.getNamn() + " | Inköpspris: " + this.inkopspris
                + " | Slitage: " + this.getSlitage() + " | Värde: " + this.getRealVarde();
    }
}
