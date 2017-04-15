import javax.swing.*;

/**
 * Patrick Virtanen
 * Matilda Höglund - 920222-2767
 */
public class NyApparat extends JPanel {
	private JTextField namnFalt = new JTextField(10);
	private JTextField prisFalt = new JTextField(5);
	private JTextField slitageFalt = new JTextField(5);

	public NyApparat() {
		setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
		JPanel rad1 = new JPanel();
		add(rad1);
		rad1.add(new JLabel("Namn:"));
		rad1.add(namnFalt);
		JPanel rad2 = new JPanel();
		add(rad2);
		rad2.add(new JLabel("Pris:"));
		rad2.add(prisFalt);
		JPanel rad3 = new JPanel();
		add(rad3);
		rad3.add(new JLabel("Slitage:"));
		rad3.add(slitageFalt);
	}

	public String getNamn() {
		return namnFalt.getText();
	}

	public double getPris() {
		return Double.parseDouble(prisFalt.getText());
	}

	public String getPrisFalt() {
		return prisFalt.getText();
	}

	public int getSlitage() {
		return Integer.parseInt(slitageFalt.getText());
	}

	public String getSlitageFalt() {
		return slitageFalt.getText();
	}
}
