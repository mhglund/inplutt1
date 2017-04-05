import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * inlupp 1 PROG2
 */

public class InpluppProgram extends JFrame implements ActionListener {
	private ArrayList<Vardesak> saker = new ArrayList<>(); // Återaktiverade denna för att sortera objekten
	private ArrayList<Smycke> smycken = new ArrayList<>();
	private ArrayList<Aktie> aktier = new ArrayList<>();
	private ArrayList<Apparat> apparater = new ArrayList<>();

	// Bör kanske deklareras inne i fonsterRuta?
	private String[] vardesaker = { "Välj värdesak", "Smycke", "Aktie", "Apparat" };
	private JComboBox<String> box = new JComboBox<>(vardesaker);

	// private JTextField textFalt;
	// private JLabel label;
	private JTextArea textRuta = new JTextArea("", 18, 17);
	private JScrollPane skrollPanel = new JScrollPane(textRuta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public void run() { // la till run() för att ha metoderna här
		fonsterRuta();
		//sortByName();
		sortVarde();
	}

	public void fonsterRuta() {
		setLayout(new BorderLayout());

		// Samlat deklarationen och tilläggningen till fönstret så det blir
		// tydligare
		JPanel topPanel = new JPanel();
		// Kan tänka this.add(föremål, position) -- står det inget innan metoden
		// så kan en tänka
		// att det är this.metod
		add(topPanel, BorderLayout.NORTH);

		JPanel bottenPanel = new JPanel();
		add(bottenPanel, BorderLayout.SOUTH);

		JPanel mittPanel = new JPanel();
		add(mittPanel, BorderLayout.CENTER);
		mittPanel.setLayout(new BorderLayout());
		mittPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel hogerPanel = new JPanel();
		add(hogerPanel, BorderLayout.EAST);
		hogerPanel.setBorder(new EmptyBorder(5, 5, 5, 20));
		hogerPanel.setLayout(new BoxLayout(hogerPanel, BoxLayout.Y_AXIS));

		// behållare.add(föremål)
		topPanel.add(new JLabel("Värdesaker"));

		mittPanel.add(skrollPanel, BorderLayout.CENTER);

		bottenPanel.add(new JLabel("Nytt: "));

		// droppmenyn läggs till
		bottenPanel.add(box);

		JButton visaKnapp = new JButton("Visa");
		bottenPanel.add(visaKnapp);
		// visaKnapp.addActionListener(this);

		JButton borsKnapp = new JButton("Börskrasch");
		bottenPanel.add(borsKnapp);
		// borsKnapp.addActionListener(this);

		hogerPanel.add(new JLabel("Sortering"));
		JRadioButton namnSort = new JRadioButton("Namn", true);
		JRadioButton vardeSort = new JRadioButton("Värde", false);
		hogerPanel.add(namnSort);
		hogerPanel.add(vardeSort);
		ButtonGroup bg = new ButtonGroup();
		bg.add(namnSort);
		bg.add(vardeSort);

		box.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocation(300, 200);
		setVisible(true);

	}

	public void sortByName() { // Jag la till varje sak i värdesaks arraylisten,
								// måste vi ha en arraylis för varje objekt?

		for (Smycke s : smycken) {
			saker.add(s);
		}
		for (Aktie a : aktier) {
			saker.add(a);
		}
		for (Apparat app : apparater) {
			saker.add(app);
		}
		System.out.println(saker);
	}

	public void sortVarde() {
		for (Vardesak v : saker){
			v.sortVarde(v);
			System.out.println(v);
		}
	}

	public InpluppProgram() {
		super("Sakregister");
	}

	public void actionPerformed(ActionEvent ave) {
		if (box.getSelectedIndex() == 1) {
			textRuta.setText("Du har valt smycke");
			nyttSmycke();
		} else if (box.getSelectedIndex() == 2) {
			textRuta.setText("Du har valt aktie");
		} else if (box.getSelectedIndex() == 3) {
			textRuta.setText("Du har valt apparat");
		}
	}

	public void nyttSmycke() {
		NyttSmycke form = new NyttSmycke();

		while (true) {
			int test = JOptionPane.showConfirmDialog(null, form, "Nytt smycke", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(test);
			// kollar ifall användaren trycker på "Avbryt" eller kryssrutan
			if (test == 2 || test == -1) {
				break;
			}
			if (form.getNamn() == null || form.getNamn().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i namnet!", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			try {
				//stilfråga -- hämta ut och lagra i variabler eller hämta direkt sen
				String namn = form.getNamn();
				int stenar = form.getStenar();
				boolean guld = form.getGuld();
				Smycke s1 = new Smycke(namn, stenar, guld);
				saker.add(s1);
				System.out.println(s1);
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Fel format!", "Fel", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void setUp() {
		Smycke s1 = new Smycke("halsband", 12, true);
		smycken.add(s1);
		Smycke s2 = new Smycke("Armband", 3, true);
		smycken.add(s2);
		Aktie ak1 = new Aktie("Ericsson", 4, 0.25);
		aktier.add(ak1);
		Apparat ap1 = new Apparat("teve", 3000.00, 5);
		apparater.add(ap1);

		System.out.println(smycken.get(0));
		System.out.println(aktier.get(0));
		System.out.println(apparater.get(0));

		Apparat ap2 = new Apparat("Ipad", 3000.00, 1);
		apparater.add(ap2);
		Apparat ap3 = new Apparat("Android", 2000.00, 7);
		apparater.add(ap3);

		Collections.sort(smycken); // <-- Jag vill lägga denna kod på ett annat
									// ställe, men det gick inte så bra. Koden
									// fick förbli kvar.
		Collections.sort(aktier);
		Collections.sort(apparater);

	}

	public static void main(String args[]) {
		InpluppProgram program = new InpluppProgram();
		program.setUp();
		program.run();

	}

	static {
		Font f = new Font("Dialog", Font.BOLD, 16);
		String[] comps = { "Button", "Label", "RadioButton", "CheckBox", "ToggleButton", "TextArea", "TextField",
				"Menu", "MenuItem", "FileChooser", "Dialog", "OptionPane" };
		for (String s : comps) {
			UIManager.put(s + ".font", f);
		}

	}
}
