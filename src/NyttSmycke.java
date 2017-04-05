import javax.swing.*;

/**
 * Created by tildas on 2017-04-05.
 */
public class NyttSmycke extends JPanel{
	private JTextField namnFalt = new JTextField(10);
	private JTextField stenFalt = new JTextField(5);
	private JCheckBox guldBox = new JCheckBox("Guld");


	public NyttSmycke() {
		//ska vara en vertikal box-layout
		setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
		JPanel rad1 = new JPanel();
		add(rad1);
		rad1.add(new JLabel("Namn:"));
		rad1.add(namnFalt);
		JPanel rad2 = new JPanel();
		add(rad2);
		rad2.add(new JLabel("Antal stenar:"));
		rad2.add(stenFalt);
		//rad 3 består bara av checkboxen
		add(guldBox);

	}

	public String getNamn() {
		return namnFalt.getText();
	}

	public int getStenar() {
		//ifall användaren fyller i bokstäver istället för siffor så kommer den kasta ett numberException
		return Integer.parseInt(stenFalt.getText());
	}

	public boolean getGuld() {
		return guldBox.isSelected();
	}
}
