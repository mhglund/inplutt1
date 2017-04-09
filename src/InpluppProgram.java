import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.*;

/**
 * inlupp 1 PROG2
 */

public class InpluppProgram extends JFrame implements ActionListener {
	private ArrayList<Vardesak> saker = new ArrayList<>();

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
	}

	public void fonsterRuta() {
		setLayout(new BorderLayout());

		// Samlat deklarationen och tilläggningen till fönstret så det blir tydligare
		JPanel topPanel = new JPanel();
		// Kan tänka this.add(föremål, position) -- står det inget innan metoden så kan en tänka att det är this.metod
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
		visaKnapp.addActionListener(new VisaLyss());

		JButton borsKnapp = new JButton("Börskrasch");
		bottenPanel.add(borsKnapp);
		// borsKnapp.addActionListener(this);

		hogerPanel.add(new JLabel("Sortering"));
		JRadioButton namnSort = new JRadioButton("Namn", false);
		namnSort.addActionListener(new visaSortering());
		JRadioButton vardeSort = new JRadioButton("Värde", false);
		vardeSort.addActionListener(new vardeSortering());
		hogerPanel.add(namnSort);
		hogerPanel.add(vardeSort);
		ButtonGroup bg = new ButtonGroup();
		bg.add(namnSort);
		bg.add(vardeSort);

		box.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 400);
		setLocation(300, 200);
		setVisible(true);

	}

	public void sortByName() { // Jag la till varje sak i värdesaks arraylisten måste vi ha en arraylis för varje objekt?

		System.out.println("****Här börjar namn sortering**** \n ");
		Collections.sort(saker, new Comparator<Vardesak>() {

			public int compare(Vardesak result1, Vardesak result2) {
				return result1.getNamn().compareTo(result2.getNamn());

			}
		});
		for (Vardesak resultInstance : saker) {
			textRuta.append(resultInstance + "\n");
		}

	}

	public void sortVarde() {
		System.out.println("\n ****Här börjar värde sortering**** \n");
		Collections.sort(saker, new Comparator<Vardesak>() {

			public int compare(Vardesak result1, Vardesak result2) {
				return result1.getRealVarde().compareTo(result2.getRealVarde());

			}
		});
		for (Vardesak resultInstance : saker) {
			textRuta.append(resultInstance + "\n");
		}
	}

	public InpluppProgram() {
		super("Sakregister");
	}

	//Ska flyttalen skrivas ut med punkt (.) eller kommatecken (,)?
	class VisaLyss implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			textRuta.setText("");
			for (Vardesak v : saker) {
				textRuta.append(v.toString() + "\n");
			}
		}
	}

	class visaSortering implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			textRuta.setText("");
			sortByName();

		}
	}

	class vardeSortering implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			textRuta.setText("");
			sortVarde();

		}
	}

	public void actionPerformed(ActionEvent ave) {
		if (box.getSelectedIndex() == 1) {
			textRuta.setText("Du har valt smycke");
			nyttSmycke();
		} else if (box.getSelectedIndex() == 2) {
			textRuta.setText("Du har valt aktie");
			nyAktie();
		} else if (box.getSelectedIndex() == 3) {
			textRuta.setText("Du har valt apparat");
			nyApparat();
		}
	}

	//Finns ingen felhantering för ifall namnen på värdesakerna är siffror, men det står inte heller
	// som krav så jag tror vi skippar det? Kommer bli en rätt krånlig lösning annars, då prylar ju
	// kan ha en siffra i sig. Typ Chanel no5, eller nåt.

	public void nyttSmycke() {
		NyttSmycke smyckesForm = new NyttSmycke();
		while (true) {
			int test = JOptionPane.showConfirmDialog(null, smyckesForm, "Nytt smycke", JOptionPane.OK_CANCEL_OPTION);
			// kollar ifall användaren trycker på "Avbryt" eller kryssrutan
			if (test == 2 || test == -1) {
				break;
			}
			if (smyckesForm.getNamn() == null || smyckesForm.getNamn().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i namnet!", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			} else if (smyckesForm.getStenar() < 0) {
				JOptionPane.showMessageDialog(null, "Antalet stenar kan ej vara negativt", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			try {
				// stilfråga -- hämta ut och lagra i variabler eller hämta direkt sen
				String namn = smyckesForm.getNamn();
				int stenar = smyckesForm.getStenar();
				boolean guld = smyckesForm.getGuld();
				Smycke s1 = new Smycke(namn, stenar, guld);
				saker.add(s1);
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Fel format!", "Fel", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void nyAktie() {
		NyAktie aktieForm = new NyAktie();
		while (true) {
			int test = JOptionPane.showConfirmDialog(null, aktieForm, "Ny aktie", JOptionPane.OK_CANCEL_OPTION);
			if (test == 2 || test == -1) {
				break;
			}
			if (aktieForm.getNamn() == null || aktieForm.getNamn().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i namnet", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			} else if (aktieForm.getAntal() < 1) {
				JOptionPane.showMessageDialog(null, "Antalet måste vara mer än 1", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			try {
				String namn = aktieForm.getNamn();
				int antal = aktieForm.getAntal();
				Double kurs = aktieForm.getKurs();
				Aktie ak1 = new Aktie(namn, antal, kurs);
				saker.add(ak1);
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Fel format!", "Fel", JOptionPane.ERROR_MESSAGE);
			}
		}
	}


	public void nyApparat() {
		NyApparat apparatForm = new NyApparat();
		while(true) {
			int test = JOptionPane.showConfirmDialog(null, apparatForm, "Ny apparat", JOptionPane.OK_CANCEL_OPTION);
			if (test == 2 || test == -1) {
				break;
			}
			if (apparatForm.getNamn() == null || apparatForm.getNamn().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i namnet", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			} else if (apparatForm.getSlitage() > 10 || apparatForm.getSlitage() < 1) {
				JOptionPane.showMessageDialog(null, "Slitagevärdet måste vara mellan 1--10", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			try {
				String namn = apparatForm.getNamn();
				Double pris = apparatForm.getPris();
				int slitage = apparatForm.getSlitage();
				Apparat ap1 = new Apparat(namn, pris, slitage);
				saker.add(ap1);
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Fel format!", "Fel", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void setUp() {
		Smycke s1 = new Smycke("Halsband", 1, true);
		saker.add(s1);
		Smycke s2 = new Smycke("Armband", 3, true);
		saker.add(s2);
		Aktie ak1 = new Aktie("Ericsson", 4, 0.25);
		saker.add(ak1);
		Apparat ap1 = new Apparat("Teve", 3000.00, 5);
		saker.add(ap1);
		Apparat ap2 = new Apparat("Ipad", 6000.00, 1);
		saker.add(ap2);
		Apparat ap3 = new Apparat("Android", 2000.00, 7);
		saker.add(ap3);

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
