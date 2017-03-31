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

<<<<<<< HEAD
	private JRadioButton rNamn = new JRadioButton("Namn", true), rVärde = new JRadioButton("Värde", false);
	private JTextArea area = new JTextArea(10, 60);
	
	private JTextField textFalt;
	private JLabel label;
=======
	//private JTextField textFalt;
	//private JLabel label;
    private JTextArea textRuta = new JTextArea("", 18, 17);
    private JScrollPane skrollPanel = new JScrollPane(textRuta,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
>>>>>>> 141c16f0db0900bdcfde7025e741da17d64c1e28


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
        mittPanel.setLayout(new BorderLayout());
        mittPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel hogerPanel = new JPanel();
<<<<<<< HEAD

		JPanel mittenPanel = new JPanel();
		
		

		/*TOPP PANELEN*/

        add(hogerPanel, BorderLayout.EAST);
        hogerPanel.setBorder(new EmptyBorder(5, 5, 5, 20));
        hogerPanel.setLayout(new BoxLayout(hogerPanel, BoxLayout.Y_AXIS));

        // behållare.add(föremål)
=======
        add(hogerPanel, BorderLayout.EAST);
        hogerPanel.setBorder(new EmptyBorder(5, 5, 5, 20));
        hogerPanel.setLayout(new BoxLayout(hogerPanel, BoxLayout.Y_AXIS));
>>>>>>> 141c16f0db0900bdcfde7025e741da17d64c1e28

        // behållare.add(föremål)
		topPanel.add(new JLabel("Värdesaker"));

<<<<<<< HEAD

		
		/*Botten PANELEN*/
		bottenPanel.add(new JLabel("Nytt:"));
		add(bottenPanel, BorderLayout.SOUTH);
=======
        mittPanel.add(skrollPanel, BorderLayout.CENTER);

        bottenPanel.add(new JLabel("Nytt: "));
>>>>>>> 141c16f0db0900bdcfde7025e741da17d64c1e28

        mittPanel.add(skrollPanel, BorderLayout.CENTER);

        bottenPanel.add(new JLabel("Nytt: "));


		// objekt som läggs till i droppmenyn
		box.addItem("Smycke");
		box.addItem("Aktie");
		box.addItem("Apparat");
		bottenPanel.add(box);

<<<<<<< HEAD
		
		
		bottenPanel.add(new JButton("Visa"));
		add(bottenPanel, BorderLayout.SOUTH);
		
		bottenPanel.add(new JButton("Börskrasch"));
		add(bottenPanel, BorderLayout.SOUTH);
		
		
		/*HÖGER PANELEN*/
		hogerPanel.setLayout(new BoxLayout(hogerPanel, BoxLayout.Y_AXIS));
		hogerPanel.add(new JLabel("Sortering"));
		add(hogerPanel, BorderLayout.EAST);
		
		ButtonGroup rButton = new ButtonGroup();
		rButton.add(rNamn);
		rButton.add(rVärde);
		hogerPanel.add(rNamn, BorderLayout.EAST);
		hogerPanel.add(rVärde, BorderLayout.EAST);
		
		
		/*CENTER PANELEN*/
		add(area, BorderLayout.CENTER); // när jag lägger till mittenPanel.add så fungerar det inte.
		
		
		// center verkar inte funka?? gäller det något spec för den?
		// Jag förstår inte varför CENTER strular så mycket.
		
//		JButton knapp = new JButton("Hälsa");
//		mittenPanel.add(knapp);
//		add(mittenPanel, BorderLayout.CENTER);
//		knapp.addActionListener(this);

		
		//Denna kod var det som orsakade att CENTER ej visades, vet ej varför. Denna gör dock så att
		// droppMenyn visar en text när man klickar på någon
//		label = new JLabel();
//		add(label);


=======
>>>>>>> 141c16f0db0900bdcfde7025e741da17d64c1e28
		JButton visaKnapp = new JButton("Visa");
		bottenPanel.add(visaKnapp);
		//visaKnapp.addActionListener(this);

        JButton borsKnapp = new JButton("Börskrasch");
        bottenPanel.add(borsKnapp);
        //borsKnapp.addActionListener(this);
<<<<<<< HEAD

		hogerPanel.add(new JLabel("Sortering"));
        hogerPanel.add(new JRadioButton("Namn", true));
        hogerPanel.add(new JRadioButton("Värde", false));

=======

		hogerPanel.add(new JLabel("Sortering"));
        hogerPanel.add(new JRadioButton("Namn", true));
        hogerPanel.add(new JRadioButton("Värde", false));
>>>>>>> 141c16f0db0900bdcfde7025e741da17d64c1e28

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
