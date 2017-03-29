import java.util.ArrayList;

/**
 * Created by tildas on 2017-03-22.
 */

// Hej hej , nu provar jag denna funktion

public class InpluppProgram {
    private ArrayList<Vardesak> saker = new ArrayList<>();
    private ArrayList<Smycke> smycken = new ArrayList<>();
    private ArrayList<Aktie> aktier = new ArrayList<>();
    private ArrayList<Apparat> apparater = new ArrayList<>();

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

        /*Smycke s1 = new Smycke("halsband", 2, true);
        Aktie ak1 = new Aktie("Ericsson", 4, 0.25);
        Apparat ap1 = new Apparat("teve", 3000.00, 5);*/


    }
}
