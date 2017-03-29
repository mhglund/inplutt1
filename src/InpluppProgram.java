import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * inlupp 1 PROG2
 */

	
public class InpluppProgram extends JFrame implements ActionListener  {
    //private ArrayList<Vardesak> saker = new ArrayList<>();
    private ArrayList<Smycke> smycken = new ArrayList<>();
    private ArrayList<Aktie> aktier = new ArrayList<>();
    private ArrayList<Apparat> apparater = new ArrayList<>();
    
    private JTextField textFalt;
	private JLabel halsning;

    public void fonsterRuta(){
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

        //center verkar inte funka?? gäller det något spec för den?
        JButton knapp = new JButton("Hälsa");
        mittenPanel.add(knapp);
        add(mittenPanel, BorderLayout.CENTER);
        knapp.addActionListener(this);

        halsning = new JLabel("");
        add(halsning);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,600);
        setVisible(true);

    }
	

	public InpluppProgram() {
		super("Sakregister");

	}

	public void actionPerformed(ActionEvent ave) {
		String namn = textFalt.getText();
		halsning.setText("Hej " + namn);
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
}
