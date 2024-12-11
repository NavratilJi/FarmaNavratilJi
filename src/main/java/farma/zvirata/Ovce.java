
package farma.zvirata;

/**
 *
 * @author Jiří Navrátil
 */
public class Ovce extends Zvire {
    
    private int mnozstviVlny;
    private String zvuk = "becim";

    public Ovce(String jmeno) {
        super(jmeno, ZvireTyp.OVCE);
    }

    public int getMnozstviVlny() {
        return mnozstviVlny;
    }

    public void setMnozstviVlny(int mnozstviVlny) {
        this.mnozstviVlny = mnozstviVlny;
    }

        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ovce { ");
        sb.append(super.toString());
        sb.append("zvuk: ").append(zvuk);
        sb.append(", davam ").append(mnozstviVlny).append(" kg vlny");
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public String vyvolejZvuk() {
        return zvuk;
    }
    
}
