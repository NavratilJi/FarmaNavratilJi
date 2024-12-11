package farma.zvirata;

public enum BarvaKocek {

    BILA("bila"),
    CERNA("cerna"),
    MOUROVATA("mourovata");

    private final String nazev;

    private BarvaKocek(String barva) {
        this.nazev = barva;
    }

    public String getNazev() {
        return nazev;
    }

    @Override
    public String toString() {
        return "barva: " + nazev;
    }

}
