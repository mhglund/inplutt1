import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * inlupp 1 PROG2
 */

public class InpluppProgram extends JFrame implements ActionListener {
	// private ArrayList<Vardesak> saker = new ArrayList<>();
	private ArrayList<Smycke> smycken = new ArrayList<>();
	private ArrayList<Aktie> aktier = new ArrayList<>();
	private ArrayList<Apparat> apparater = new ArrayList<>();
	private JComboBox<String> box = new JComboBox<>(); // En lista med saker till dropmenyn

	private JTextField textFalt;
	private JLabel label;

	public void fonsterRuta() {
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		JPanel bottenPanel = new JPanel();
		JPanel vansterPanel = new JPanel();
		JPanel hogerPanel = new JPanel();
		JPanel mittenPanel = new JPanel();

		topPanel.add(new JLabel("Värdesaker"));
		add(topPanel, BorderLayout.NORTH);

		bottenPanel.add(textFalt = new JTextField(8));
		add(bottenPanel, BorderLayout.SOUTH);

		// objekt som läggs till i droppmenyn
		box.addItem("Smycke");
		box.addItem("Aktie");
		box.addItem("Apparat");
		bottenPanel.add(box);

		// center verkar inte funka?? gäller det något spec för den?
		// Kommer förmodligen att fungera efter vi gjort alla andra borderlayouts.
		JButton knapp = new JButton("Hälsa");
		mittenPanel.add(knapp);
		add(mittenPanel, BorderLayout.CENTER);
		knapp.addActionListener(this);

		label = new JLabel("");
		add(label);

		box.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 600);
		setVisible(true);

	}

	public InpluppProgram() {
		super("Sakregister");

	}

	public void actionPerformed(ActionEvent ave) { // Jag lade till en lyssnare bara för att se att programmet gav response.
		if (box.getSelectedIndex() == 0) {
			label.setText("Du har valt smycke");
		} else if (box.getSelectedIndex() == 1) {
			label.setText("Du har valt aktie");
		} else if (box.getSelectedIndex() == 2) {
			label.setText("Du har valt apparat");
		}
	}

	private void setUp() {
		Smycke s1 = new Smycke("halsband", 2, true);
		smycken.add(s1);
		Aktie ak1 = new Aktie("Ericsson", 4, 0.25);
		aktier.add(ak1);
		Apparat ap1 = new Apparat("teve", 3000.00, 5);
		apparater.add(ap1);

		System.out.println(smycken.get(0));
		System.out.println(aktier.get(0));
		System.out.println(apparater.get(0));
	}

	public static void main(String args[]) {
		InpluppProgram program = new InpluppProgram();

		program.setUp();
		program.fonsterRuta();

	}

	static {
		Font f = new Font("Dialog", Font.BOLD, 20);
		String[] comps = { "Button", "Label", "RadioButton", "CheckBox", "ToggleButton", "TextArea", "TextField",
				"Menu", "MenuItem", "FileChooser", "Dialog", "OptionPane" };
		for (String s : comps) {
			UIManager.put(s + ".font", f);
		}

	}
}
