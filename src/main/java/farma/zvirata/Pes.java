package farma.zvirata;

public class Pes extends Zvire {

    private final String zvuk = "stekam";
    private float vyska;

    public Pes(String jmeno) {
        super(jmeno, ZvireTyp.PES);
    }

    public float getVyska() {
        return vyska;
    }

    public void setVyska(float vyska) {
        this.vyska = vyska;
    }

    @Override
    public String vyvolejZvuk() {
        return zvuk;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pes { ");
        sb.append(super.toString());
        sb.append("zvuk: ").append(zvuk);
        sb.append(", vyska: ").append(vyska);
        sb.append('}');
        return sb.toString();
    }

}
