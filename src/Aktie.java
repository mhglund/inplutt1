/**
 * Created by tildas on 2017-03-22.
 */
public class Aktie extends Vardesak {
    private int antal;
    private Double kurs;

    public Aktie(String namn, int antal, Double kurs) {
        super(namn);
        this.antal = antal;
        this.kurs = kurs;
    }
    
   public Double getVarde() {
        return (antal * kurs);
   }

   public Double getKurs() {
       return kurs;
   }

    public String toString() {
        return this.getNamn() + " " + this.getKurs() + " " + this.getRealVarde();
    }
}
