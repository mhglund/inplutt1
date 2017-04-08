/**
 * Created by tildas on 2017-03-22.
 */
public class Aktie extends Vardesak {
	private int antal;
	private Double kurs;

	public Aktie(String namn, int antal, Double kurs) {
		super(namn);
		this.antal = antal;
		this.kurs = kurs;
	}

	public Double getVarde() {
		return (antal * kurs);
	}

	public Double getKurs() {
		return kurs;
	}

	public int getAntal() {
		return antal;
	}

	public String toString() {
		return "Namn: " + this.getNamn() + " | Antal: " + this.getAntal() + " | Kurs: " + this.getKurs() + " | Värde: "
			+ this.getRealVarde();
	}
}
