import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

	//private JTextField textFalt;
	//private JLabel label;
    private JTextArea textRuta = new JTextArea("", 18, 17);
    private JScrollPane skrollPanel = new JScrollPane(textRuta,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public void fonsterRuta() {
		setLayout(new BorderLayout());

        //Samlat deklarationen och tilläggningen till fönstret så det blir tydligare
		JPanel topPanel = new JPanel();
        // Kan tänka this.add(föremål, position)  -- står det inget innan metoden så kan en tänka
        // att det är this.metod
        add(topPanel, BorderLayout.NORTH);

		JPanel bottenPanel = new JPanel();
        add(bottenPanel, BorderLayout.SOUTH);

		JPanel mittPanel = new JPanel();
        add(mittPanel, BorderLayout.CENTER);
        mittPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel hogerPanel = new JPanel();
        add(hogerPanel, BorderLayout.EAST);
        hogerPanel.setBorder(new EmptyBorder(5, 5, 5, 20));
        hogerPanel.setLayout(new BoxLayout(hogerPanel, BoxLayout.Y_AXIS));

        // behållare.add(föremål)
		topPanel.add(new JLabel("Värdesaker"));

        mittPanel.add(skrollPanel);

        bottenPanel.add(new JLabel("Nytt: "));

		// objekt som läggs till i droppmenyn
		box.addItem("Smycke");
		box.addItem("Aktie");
		box.addItem("Apparat");
		bottenPanel.add(box);

		JButton visaKnapp = new JButton("Visa");
		bottenPanel.add(visaKnapp);
		//visaKnapp.addActionListener(this);

        JButton borsKnapp = new JButton("Börskrasch");
        bottenPanel.add(borsKnapp);
        //borsKnapp.addActionListener(this);

		hogerPanel.add(new JLabel("Sortering"));
        hogerPanel.add(new JRadioButton("Namn", true));
        hogerPanel.add(new JRadioButton("Värde", false));

		box.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);

	}

	public InpluppProgram() {
		super("Sakregister");

	}

	public void actionPerformed(ActionEvent ave) { // Jag lade till en lyssnare bara för att se att programmet gav response.
		if (box.getSelectedIndex() == 0) {
			textRuta.setText("Du har valt smycke");
		} else if (box.getSelectedIndex() == 1) {
			textRuta.setText("Du har valt aktie");
		} else if (box.getSelectedIndex() == 2) {
			textRuta.setText("Du har valt apparat");
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
		Font f = new Font("Dialog", Font.BOLD, 16);
		String[] comps = { "Button", "Label", "RadioButton", "CheckBox", "ToggleButton", "TextArea", "TextField",
				"Menu", "MenuItem", "FileChooser", "Dialog", "OptionPane" };
		for (String s : comps) {
			UIManager.put(s + ".font", f);
		}

	}
}
