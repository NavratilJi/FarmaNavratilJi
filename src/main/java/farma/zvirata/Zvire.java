package farma.zvirata;

/**
 *
 * @author karel@simerda.cz
 */
public abstract class Zvire {

    private final String jmeno;
    private final ZvireTyp typ;
    private float hmotnost;
    private int denNarozeni;
    private int mesicNarozeni;
    private int rokNarozeni;

    public Zvire(String jmeno, ZvireTyp typ) {
        this.jmeno = jmeno;
        this.typ = typ;
    }

    public String getJmeno() {
        return jmeno;
    }

    public ZvireTyp getTyp() {
        return typ;
    }

    public float getHmotnost() {
        return hmotnost;
    }

    public void setHmotnost(float hmotnost) {
        this.hmotnost = hmotnost;
    }

    public int getDenNarozeni() {
        return denNarozeni;
    }

    public void setDenNarozeni(int denNarozeni) {
        this.denNarozeni = denNarozeni;
    }

    public int getMesicNarozeni() {
        return mesicNarozeni;
    }

    public void setMesicNarozeni(int mesicNarozeni) {
        this.mesicNarozeni = mesicNarozeni;
    }

    public int getRokNarozeni() {
        return rokNarozeni;
    }

    public void setRokNarozeni(int rokNarozeni) {
        this.rokNarozeni = rokNarozeni;
    }
    
    

    public abstract String vyvolejZvuk();

    @Override
    public String toString() {
        return typ + ", jmeno: " + jmeno + ", hmotnost: " + hmotnost + ", datum narozeni " + denNarozeni + "." + mesicNarozeni + "." + rokNarozeni + " ";
    }

}
