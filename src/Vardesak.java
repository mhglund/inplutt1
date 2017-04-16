
/**
 * Patrick Virtanen - 910706-3175
 * Matilda Höglund - 920222-2767
 */

abstract public class Vardesak implements Comparable<Vardesak> {
	private String namn;

	public Vardesak(String namn) {
		this.namn = namn;
	}

	public String getNamn() {
		return namn;
	}

	public int compareTo(Vardesak v) {
		return namn.compareTo(v.namn);
	}

	abstract public Double getVarde();

	public Double getRealVarde() {
		return getVarde() * 1.25;
	}
}
