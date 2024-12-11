package farma.zvirata;

import farma.Farma;

public class Kocka extends Zvire {

    private final String zvuk = "mnoukam";
    private BarvaKocek bk;

    public Kocka(String jmeno) {
        super(jmeno, ZvireTyp.KOCKA);
    }

    public BarvaKocek getBarva() {
        return bk;
    }

    public void setBarva(BarvaKocek bk) { this.bk = bk; }

    @Override
    public String vyvolejZvuk() {
        return zvuk;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kocka { ");
        sb.append(super.toString());
        sb.append("zvuk: ").append(zvuk);
        sb.append(", ").append(bk);
        sb.append('}');
        return sb.toString();
    }

}
