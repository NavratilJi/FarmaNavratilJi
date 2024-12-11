package farma;

import farma.zvirata.Zvire;

public class SeznamZvirat implements Seznam {

    private final Zvire[] seznam;
    private final int kapacita;
    private int pocet;
    private int index;

    public SeznamZvirat(int kapacita) {
        if (kapacita <= 0) {
            throw new IllegalArgumentException("Kapacita nu positivo");
        }
        seznam = new Zvire[kapacita + 1];
        this.kapacita = kapacita;
        // pocet = 0;
        // index = 0;
    }

    public int getKapacita() {
        return kapacita;
    }

    public int getPocet() {
        return pocet;
    }

    @Override
    public Zvire odeber(final int pozice) {
        if (pozice <= 0 || pozice > kapacita) {
            throw new IllegalArgumentException();
        }
        int i = pozice - 1;
        Zvire zvire = seznam[i];
        System.arraycopy(seznam, i + 1, seznam, i, kapacita - pocet);
        pocet--;
        return zvire;
    }

    @Override
    public void pridej(Zvire zvire) {
        if (zvire == null) {
            throw new NullPointerException();
        }
        if (pocet + 1 > kapacita) {
            throw new IllegalArgumentException();
        }
        seznam[pocet++] = zvire;
    }

    @Override
    public String vydejZvuky() {
        StringBuilder sb = new StringBuilder();
        for (Zvire zvire : seznam) {
            if (zvire != null) {
                sb.append(zvire.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public void zrus() {
        for (int i = 0; i < seznam.length; i++) {
            seznam[i] = null;
        }
        pocet = 0;
        index = 0;
    }

    @Override
    public String vypis() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seznam.length; i++) {
            if (seznam[i] == null) break;
            sb.append(seznam[i].toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void nastavPrvni() {
        index = 0;
    }

    @Override
    public Zvire dejDalsi() {
        if (index < pocet) {
            return seznam[index++];
        }
        return null;
    }

}
