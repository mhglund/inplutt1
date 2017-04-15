import javax.swing.*;

/**
 * Patrick Virtanen
 * Matilda Höglund - 920222-2767
 */
public class NyttSmycke extends JPanel{
	private JTextField namnFalt = new JTextField(10);
	private JTextField stenFalt = new JTextField(5);
	private JCheckBox guldBox = new JCheckBox("Guld");

	public NyttSmycke() {
		setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
		JPanel rad1 = new JPanel();
		add(rad1);
		rad1.add(new JLabel("Namn:"));
		rad1.add(namnFalt);
		JPanel rad2 = new JPanel();
		add(rad2);
		rad2.add(new JLabel("Antal stenar:"));
		rad2.add(stenFalt);
		add(guldBox);
	}

	public String getNamn() {
		return namnFalt.getText();
	}

	public String getStenFalt() {
		return stenFalt.getText();
	}

	public int getStenar() {
		return Integer.parseInt(stenFalt.getText());
	}

	public boolean getGuld() {
		return guldBox.isSelected();
	}
}
