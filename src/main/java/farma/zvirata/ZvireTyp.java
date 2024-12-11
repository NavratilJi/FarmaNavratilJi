package farma.zvirata;

/**
 *
 * @author karel@simerda.cz
 */
public enum ZvireTyp {
    KOCKA("Kocka"), PES("Pes"), KUN("Kun"), OVCE("Ovce");

    private final String nazev;

    private ZvireTyp(String nazev) {
        this.nazev = nazev;
    }

    @Override
    public String toString() {
        return nazev;
    }

}
