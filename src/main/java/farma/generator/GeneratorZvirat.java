package farma.generator;

import java.util.Random;

import farma.zvirata.*;

public final class GeneratorZvirat {

    private static final Random RANDOM = new Random();

    private GeneratorZvirat() {
    }

    public static Zvire[] generuj(int pocet) {
        Zvire[] zvirata = new Zvire[pocet];
        for (int i = 0; i < pocet; i++) {
            zvirata[i] = generujZvire();
        }
        System.out.println("Vygeneroval jsem 10 nahodnych zvirat");
        return zvirata;
    }

    public static Zvire generujZvire() {
        int volba = RANDOM.nextInt(ZvireTyp.values().length);
        Zvire zvire = switch (ZvireTyp.values()[volba]) {
            case KOCKA ->
                dejKocku();
            case KUN ->
                dejKone();
            case PES ->
                dejPes();
            case OVCE ->
                dejOvci();
        };
        return zvire;
    }

    private static Zvire dejKocku() {
        String[] jmena = {"Eliška", "Lupínek", "Mourek", "Bert", "Micka", "Megatron", "Zrzek", "Luna"};
        Kocka kocka = new Kocka(jmena[RANDOM.nextInt(jmena.length)]);
        kocka.setHmotnost(RANDOM.nextFloat(2, 20));
        kocka.setBarva(BarvaKocek.values()[RANDOM.nextInt(BarvaKocek.values().length)]);
        kocka.setDenNarozeni(RANDOM.nextInt(1, 31));
        kocka.setMesicNarozeni(RANDOM.nextInt(1, 12));
        kocka.setRokNarozeni(RANDOM.nextInt(1950, 2024));
        return kocka;
    }

    private static Zvire dejKone() {
        String[] jmena = {"Juan", "Lucky", "Star", "Rainbow", "Twilight", "Sparkle", "Dash"};
        Kun kun = new Kun(jmena[RANDOM.nextInt(jmena.length)]);
        kun.setHmotnost(RANDOM.nextFloat(200, 1000));
        kun.setPlemeno(PlemenaKoni.values()[RANDOM.nextInt(PlemenaKoni.values().length)]);
        kun.setVyska(RANDOM.nextFloat(100, 200));
        kun.setDenNarozeni(RANDOM.nextInt(1, 31));
        kun.setMesicNarozeni(RANDOM.nextInt(1, 12));
        kun.setRokNarozeni(RANDOM.nextInt(1950, 2024));
        return kun;
    }

    private static Zvire dejPes() {
        String[] jmena = {"Lussy", "Popdog", "Doge", "Cupcake"};
        Pes pes = new Pes(jmena[RANDOM.nextInt(jmena.length)]);
        pes.setHmotnost(RANDOM.nextFloat(2, 50));
        pes.setVyska(RANDOM.nextFloat(5, 100));
        pes.setDenNarozeni(RANDOM.nextInt(1, 31));
        pes.setMesicNarozeni(RANDOM.nextInt(1, 12));
        pes.setRokNarozeni(RANDOM.nextInt(1950, 2024));
        return pes;
    }
    
    private static Zvire dejOvci(){
        String[] jmena = {"Mlekodarce", "Vlnodarce", "Bavlnak", "Blbec"};
        Ovce ovce = new Ovce(jmena[RANDOM.nextInt(jmena.length)]);
        ovce.setHmotnost(RANDOM.nextFloat(50, 1000));
        ovce.setMnozstviVlny(RANDOM.nextInt(5, 50));
        ovce.setDenNarozeni(RANDOM.nextInt(1, 31));
        ovce.setMesicNarozeni(RANDOM.nextInt(1, 12));
        ovce.setRokNarozeni(RANDOM.nextInt(1950, 2024));
        return ovce;
    }

}
