package farma.zvirata;

public enum PlemenaKoni {

    MUSTANG("Mustang", 140),
    CRIOLLO("Criollo", 144),
    APPALOOSA("Appaloosa", 152),
    ANGLICKY_PLNOKREVNIK("Anglicky plnokrevnik", 163),
    MISSOURSKY_KLUSAK("Missoursky klusak", 153),
    FJORDSKY_KUN("Fjordsky kun", 137);

    private final String plemeno;
    private final float prumernaVyska;

    private PlemenaKoni(String plemeno, float prumernaVyska) {
        this.plemeno = plemeno;
        this.prumernaVyska = prumernaVyska;
    }

    public String getPlemeno() {
        return plemeno;
    }

    public float getPrumernaVyska() {
        return prumernaVyska;
    }

    @Override
    public String toString() {
        return "plemeno: " + plemeno
                + " prumerna vyska plemene: " + prumernaVyska;
    }

    

}
