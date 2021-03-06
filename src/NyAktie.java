import javax.swing.*;

/**
 * Patrick Virtanen - 910706-3175
 * Matilda Höglund - 920222-2767
 */
public class NyAktie extends JPanel {
	private JTextField namnFalt = new JTextField(10);
	private JTextField antalFalt = new JTextField(5);
	private JTextField kursFalt = new JTextField(5);

	public NyAktie() {
		setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
		JPanel rad1 = new JPanel();
		add(rad1);
		rad1.add(new JLabel("Namn:"));
		rad1.add(namnFalt);
		JPanel rad2 = new JPanel();
		add(rad2);
		rad2.add(new JLabel("Antal:"));
		rad2.add(antalFalt);
		JPanel rad3 = new JPanel();
		add(rad3);
		rad3.add(new JLabel("Kurs:"));
		rad3.add(kursFalt);
	}

	public String getNamn() {
		return namnFalt.getText();
	}

	public int getAntal() {
		return Integer.parseInt(antalFalt.getText());
	}

	public String getAntalFalt() {
		return antalFalt.getText();
	}

	public Double getKurs() {
		return Double.parseDouble(kursFalt.getText());
	}

	public String getKursFalt() {
		return kursFalt.getText();
	}
}
