import java.util.ArrayList;

/**
 * Created by tildas on 2017-03-22.
 */
public class Smycke extends Vardesak {
	private int antalStenar;
	private boolean material; // true=guld, false=silver
	private Double tempVarde;

	public Smycke(String namn, int antalStenar, boolean material) {
		super(namn);
		this.antalStenar = antalStenar;
		this.material = material;
	}

	public int getAntalStenar() {
		return antalStenar;
	}

	public boolean getMaterial() {
		return material;
	}

	public String getMaterialNamn() {
		if (material) {
			return "Guld";
		} else {
			return "Silver";
		}
	}

	public Double getVarde() {
		if (material) {
			tempVarde = 2000.00;
		} else {
			tempVarde = 700.00;
		}
		return (tempVarde + (500 * antalStenar));

	}

	public String toString() {
		// felet var att vi inte anropade getRealVarde()...
		return this.getNamn() + " " + this.getMaterialNamn() + " " + this.getRealVarde();
	}

}
