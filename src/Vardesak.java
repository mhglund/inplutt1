
/**
 * Created by tildas on 2017-03-22.
 */

abstract public class Vardesak implements Comparable<Vardesak> {
	private String namn;
	private Double varde;

	public Vardesak(String namn) {
		this.namn = namn;
		//this.varde = varde * 1.25;
	}

	public String getNamn() {
		return namn;
	}

	public int compareTo(Vardesak v) {
		return namn.compareTo(v.namn);
	}

	abstract public Double getVarde();

	public Double getRealVarde() {
		varde = getVarde() * 1.25;
		return varde;
	}

}
