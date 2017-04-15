import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.*;

/**
 * inlupp 1 PROG2
 * Patrick Virtanen
 * Matilda Höglund - 920222-2767
 */

public class InpluppProgram extends JFrame implements ActionListener {
	private ArrayList<Vardesak> saker = new ArrayList<>();
	private ArrayList<Aktie> aktier = new ArrayList<>();

	private String[] vardesaker = { "Välj värdesak", "Smycke", "Aktie", "Apparat" };
	private JComboBox<String> box = new JComboBox<>(vardesaker);

	private JRadioButton namnSort = new JRadioButton("Namn", false);
	private JRadioButton vardeSort = new JRadioButton("Värde", false);

	private JTextArea textRuta = new JTextArea("", 18, 17);
	private JScrollPane skrollPanel = new JScrollPane(textRuta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	private void run() {
		setUp();
		fonsterRuta();
	}

	private void fonsterRuta() {
		setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
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

		topPanel.add(new JLabel("Värdesaker"));

		mittPanel.add(skrollPanel, BorderLayout.CENTER);

		bottenPanel.add(new JLabel("Nytt: "));

		bottenPanel.add(box);

		JButton visaKnapp = new JButton("Visa");
		bottenPanel.add(visaKnapp);
		visaKnapp.addActionListener(new VisaLyss());

		JButton borsKnapp = new JButton("Börskrasch");
		bottenPanel.add(borsKnapp);
		borsKnapp.addActionListener(new Borskrasch());

		hogerPanel.add(new JLabel("Sortering"));

		namnSort.addActionListener(new visaSortering());

		vardeSort.addActionListener(new vardeSortering());
		hogerPanel.add(namnSort);
		hogerPanel.add(vardeSort);
		ButtonGroup bg = new ButtonGroup();
		bg.add(namnSort);
		bg.add(vardeSort);

		box.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(550, 400);
		setLocation(300, 200);
		setVisible(true);
	}

	private void sortByName() {
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

	private void sortVarde() {
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

	private InpluppProgram() {
		super("Sakregister");
	}

	class VisaLyss implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			textRuta.setText("");
			for (Vardesak v : saker) {
				textRuta.append(v.toString() + "\n");
			}
		}
	}

	class Borskrasch implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			for (Aktie ak : aktier) {
				ak.setKurs(0.0);
			}
			//Skriver ut alla aktier för att tydliggöra nollställningen
			textRuta.setText("");
			for (Aktie a : aktier) {
				textRuta.append(a.toString() + "\n");
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
			nyttSmycke();
		} else if (box.getSelectedIndex() == 2) {
			nyAktie();
		} else if (box.getSelectedIndex() == 3) {
			nyApparat();
		}
	}

	private void sorteraNytt() {
		if (namnSort.isSelected()) {
			sortByName();
		} else if (vardeSort.isSelected()) {
			sortVarde();
		}
	}

	private void nyttSmycke() {
		NyttSmycke smyckesForm = new NyttSmycke();
		while (true) {
			int test = JOptionPane.showConfirmDialog(null, smyckesForm, "Nytt smycke", JOptionPane.OK_CANCEL_OPTION);
			if (test == 2 || test == -1) {
				break;
			}
			if (smyckesForm.getNamn() == null || smyckesForm.getNamn().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i namnet!", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			} else if (smyckesForm.getStenFalt() == null || smyckesForm.getStenFalt().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i antalet stenar!", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			} else if (smyckesForm.getStenar() < 0) {
				JOptionPane.showMessageDialog(null, "Antalet stenar kan ej vara negativt", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			try {
				String namn = smyckesForm.getNamn();
				int stenar = smyckesForm.getStenar();
				boolean guld = smyckesForm.getGuld();
				Smycke s1 = new Smycke(namn, stenar, guld);
				saker.add(s1);
				sorteraNytt();
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Fel format!", "Fel", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void nyAktie() {
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
			} else if (aktieForm.getAntalFalt() == null || aktieForm.getAntalFalt().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i antalet", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			} else if (aktieForm.getKursFalt() == null || aktieForm.getKursFalt().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i kursen", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			try {
				String namn = aktieForm.getNamn();
				int antal = aktieForm.getAntal();
				Double kurs = aktieForm.getKurs();
				Aktie ak1 = new Aktie(namn, antal, kurs);
				saker.add(ak1);
				aktier.add(ak1);
				sorteraNytt();
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Fel format!", "Fel", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void nyApparat() {
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
			} else if (apparatForm.getPrisFalt() == null || apparatForm.getPrisFalt().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i priset", "Fel", JOptionPane.ERROR_MESSAGE);
			} else if (apparatForm.getSlitageFalt() == null || apparatForm.getSlitageFalt().equals("")) {
				JOptionPane.showMessageDialog(null, "Fyll i slitage", "Fel", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			try {
				String namn = apparatForm.getNamn();
				Double pris = apparatForm.getPris();
				int slitage = apparatForm.getSlitage();
				Apparat ap1 = new Apparat(namn, pris, slitage);
				saker.add(ap1);
				sorteraNytt();
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
		aktier.add(ak1);
		Aktie ak2 = new Aktie("Apple", 8, 5.5);
		saker.add(ak2);
		aktier.add(ak2);
		Apparat ap1 = new Apparat("Teve", 3000.00, 5);
		saker.add(ap1);
		Apparat ap2 = new Apparat("Ipad", 6000.00, 1);
		saker.add(ap2);
		Apparat ap3 = new Apparat("Android", 2000.00, 7);
		saker.add(ap3);
	}

	public static void main(String args[]) {
		InpluppProgram program = new InpluppProgram();
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
