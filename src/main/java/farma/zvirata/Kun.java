package farma.zvirata;

public class Kun extends Zvire {

    private final String zvuk = "rehtam";
    private float vyska;
    private PlemenaKoni pk;

    public Kun(String jmeno) {
        super(jmeno, ZvireTyp.KUN);
    }

    public float getVyska() {
        return vyska;
    }

    public void setVyska(float vyska) {
        this.vyska = vyska;
    }

    public PlemenaKoni getPlemeno() {
        return pk;
    }

    public void setPlemeno(PlemenaKoni pk) { this.pk = pk; }

    @Override
    public String vyvolejZvuk() {
        return zvuk;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kun { ");
        sb.append(super.toString());
        sb.append("zvuk: ").append(zvuk);
        sb.append(", ").append(pk.getPlemeno());
        sb.append(", vyska: ").append(vyska);
        sb.append('}');
        return sb.toString();
    }

}
