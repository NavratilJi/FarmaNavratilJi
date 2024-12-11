package farma;

import farma.generator.GeneratorZvirat;
import farma.zvirata.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Command implements Runnable {

    private static final Path path  = Path.of(System.getenv("APPDATA"), "farma", "zvirata.txt");

    private static final Scanner scanner = new Scanner(System.in);

    private SeznamZvirat seznam;

    public Command(int kapacita) {
        seznam = new SeznamZvirat(kapacita);
    }

    @Override
    public void run() {
        System.out.println("Evidence zvirat na farme.");
        boolean run = true;

        try {
            if (new File(path.getParent().toString()).mkdir()) {
                System.out.println("Slozka vytvořena!");
            }
            else {
                System.out.println("Slozka již existuje");
            }

            File file = new File(path.toString());
            if (file.createNewFile()) {
                System.out.println("Soubor vytvořen.");
            }
            else {
                System.out.println("Soubor již existuje!");
            }
        }
        catch (IOException ex) { Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex); }

        do {
            System.out.print("Zadej prikaz: ");
            System.out.println("(p)ridej, (o)deber, (u)loz, (n)acti, (g)eneruj, (r)eset, (s)mazat, (v)ypis, (e)xit");
            String line = scanner.nextLine();
            try {
                switch (line) {
                    case "p", "pridej" ->
                        pridejNoveZvire();
                    case "o", "odeber" ->
                        odeberZvire();
                    case "u", "uloz" ->
                        ulozZvirata();
                    case "n", "nacti" ->
                        nactiZvirata();
                    case "g", "generuj" ->
                        seznam.pridej(GeneratorZvirat.generuj(10));
                    case "r", "reset" ->
                        seznam.zrus();
                    case "s", "smazat" -> {
                        try {
                            new FileWriter(path.toString(), false).close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case "v", "vypis" ->
                        vypisZvirata();
                    case "k", "e", "exit" ->
                        run = false;
                    default -> System.out.println("Chybny prikaz");
                }
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
                System.out.println();
            }
        } while (run);
        System.out.println("Konec evidence zvirat na farme.");
    }

    private void pridejNoveZvire() {
        int den = 0;
        int mesic = 0;
        int rok = 0;
        int pomoc = 0;
        System.out.print("Zvol (p)es (k)ocka ku(n) (o)vce: ");
        String typ = scanner.nextLine();
        System.out.print("Jmeno zvirete: ");
        String jmeno = scanner.nextLine();
        System.out.print("Zadej hmotnost zvirete: ");
        float hmotnost = scanner.nextFloat();
        System.out.println("Zadej den narozeni zvirete (napriklad 20)");
        pomoc = scanner.nextInt();
        if(pomoc > 0 && pomoc <= 31){
            den = pomoc;
        }
        System.out.println("Zadej mesic narozeni zvirete (napriklad 9)");
        pomoc = scanner.nextInt();
        if(pomoc > 0 && pomoc <= 12){
            mesic = pomoc;
        }
        System.out.println("Zadej rok narozeni zvirete (napriklad 1995)");
        pomoc = scanner.nextInt();
        if(pomoc > 1950 && pomoc <= 2024){
            rok = pomoc;
        }

        switch (typ) {
            case "p" -> {
                Pes pes = new Pes(jmeno);
                pes.setHmotnost(hmotnost);
                System.out.print("Zadej vysku: ");
                pes.setVyska(scanner.nextFloat());
                seznam.pridej(pes);
            }
            case "n" -> {
                Kun kun = new Kun(jmeno);
                kun.setHmotnost(hmotnost);
                System.out.print("Zadej vysku: ");
                kun.setVyska(scanner.nextFloat());
                System.out.print("Zadej plemeno 0-Mustang, 1-Criollo, 2-Appaloosa, 3-Anglicky 4-Missoursky 5-Fjordsky: ");
                kun.setPlemeno(PlemenaKoni.values()[scanner.nextInt()]);
                kun.setDenNarozeni(den);
                kun.setMesicNarozeni(mesic);
                kun.setRokNarozeni(rok);
                seznam.pridej(kun);
            }
            case "k" -> {
                Kocka kocka = new Kocka(jmeno);
                kocka.setHmotnost(hmotnost);
                System.out.print("Zadej barvu 0-bila, 1-cerna 2-mourovata: ");
                kocka.setBarva(BarvaKocek.values()[scanner.nextInt()]);
                kocka.setDenNarozeni(den);
                kocka.setMesicNarozeni(mesic);
                kocka.setRokNarozeni(rok);
                seznam.pridej(kocka);
            }
            case "o" -> {
                Ovce ovce = new Ovce(jmeno);
                ovce.setHmotnost(hmotnost);
                System.out.println("Zadej mnozstvi vlny co nam ovce dava");
                ovce.setMnozstviVlny(scanner.nextInt());
                ovce.setDenNarozeni(den);
                ovce.setMesicNarozeni(mesic);
                ovce.setRokNarozeni(rok);
                seznam.pridej(ovce);
            }
        }
    }

    private void odeberZvire() {
        System.out.print("Zadejte poradi zvirete: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        try {
            Zvire zvire = seznam.odeber(index);
            String str = new StringBuilder().append(zvire.getTyp().toString())
                    .append(" ").append(zvire.getJmeno())
                    .append(" byl uspesne odebran/a.")
                    .toString();
            System.out.println(str);
        } catch (Exception ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ulozZvirata() {
        try {
            String str = "";
            Zvire zvire = seznam.dejDalsi();
            while (zvire != null) {
                switch (zvire.getTyp()) {
                    case KOCKA -> {
                        Kocka kocka = (Kocka) zvire;
                        str = new StringBuilder()
                                .append("kocka")
                                .append(",").append(kocka.getJmeno())
                                .append(",").append(kocka.getHmotnost())
                                .append(",").append(kocka.getBarva().ordinal())
                                .append(",").append(kocka.getDenNarozeni())
                                .append(",").append(kocka.getMesicNarozeni())
                                .append(",").append(kocka.getRokNarozeni())
                                .toString();
                    }
                    case PES -> {
                        Pes pes = (Pes) zvire;
                        str = new StringBuilder()
                                .append("pes")
                                .append(",").append(pes.getJmeno())
                                .append(",").append(pes.getHmotnost())
                                .append(",").append(pes.getVyska())
                                .append(",").append(pes.getDenNarozeni())
                                .append(",").append(pes.getMesicNarozeni())
                                .append(",").append(pes.getRokNarozeni())
                                .toString();
                    }
                    case KUN -> {
                        Kun kun = (Kun) zvire;
                        str = new StringBuilder()
                                .append("kun")
                                .append(",").append(kun.getJmeno())
                                .append(",").append(kun.getHmotnost())
                                .append(",").append(kun.getVyska())
                                .append(",").append(kun.getPlemeno().ordinal())
                                .append(",").append(kun.getDenNarozeni())
                                .append(",").append(kun.getMesicNarozeni())
                                .append(",").append(kun.getRokNarozeni())
                                .toString();
                    }
                    case OVCE -> {
                        Ovce ovce = (Ovce) zvire;
                        str = new StringBuilder()
                                .append("ovce")
                                .append(",").append(ovce.getJmeno())
                                .append(",").append(ovce.getHmotnost())
                                .append(",").append(ovce.getMnozstviVlny())
                                .append(",").append(ovce.getDenNarozeni())
                                .append(",").append(ovce.getMesicNarozeni())
                                .append(",").append(ovce.getRokNarozeni())
                                .toString();
                    }
                }
                Files.writeString(path, str + System.lineSeparator(), StandardOpenOption.APPEND);
                zvire = seznam.dejDalsi();
            }
        } catch (IOException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Zvirata byla uspesne ulozena");
    }

    private void nactiZvirata() {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] split = line.split(",");
                String jmeno = split[1];
                float hmotnost = Float.parseFloat(split[2]);
                switch (split[0]) {
                    case "kocka" -> {
                        Kocka kocka = new Kocka(jmeno);
                        int index = Integer.parseInt(split[3]);
                        BarvaKocek barva = BarvaKocek.values()[index];
                        kocka.setBarva(barva);
                        kocka.setHmotnost(hmotnost);
                        int den = Integer.parseInt(split[4]);
                        kocka.setDenNarozeni(den);
                        int mesic = Integer.parseInt(split[5]);
                        kocka.setMesicNarozeni(mesic);
                        int rok = Integer.parseInt(split[6]);
                        kocka.setRokNarozeni(rok);
                        seznam.pridej(kocka);
                    }
                    case "pes" -> {
                        Pes pes = new Pes(jmeno);
                        float vyska = Float.parseFloat(split[3]);
                        pes.setVyska(vyska);
                        pes.setHmotnost(hmotnost);
                        int den = Integer.parseInt(split[4]);
                        pes.setDenNarozeni(den);
                        int mesic = Integer.parseInt(split[5]);
                        pes.setMesicNarozeni(mesic);
                        int rok = Integer.parseInt(split[6]);
                        pes.setRokNarozeni(rok);
                        seznam.pridej(pes);
                    }
                    case "kun" -> {
                        Kun kun = new Kun(jmeno);
                        float vyska = Float.parseFloat(split[3]);
                        int index = Integer.parseInt(split[4]);
                        PlemenaKoni plemeno = PlemenaKoni.values()[index];
                        kun.setVyska(vyska);
                        kun.setHmotnost(hmotnost);
                        kun.setPlemeno(plemeno);
                        int den = Integer.parseInt(split[5]);
                        kun.setDenNarozeni(den);
                        int mesic = Integer.parseInt(split[6]);
                        kun.setMesicNarozeni(mesic);
                        int rok = Integer.parseInt(split[7]);
                        kun.setRokNarozeni(rok);
                        seznam.pridej(kun);
                    }
                    case "ovce" -> {
                        Ovce ovce = new Ovce(jmeno);
                        ovce.setHmotnost(hmotnost);
                        int vlna = Integer.parseInt(split[3]);
                        ovce.setMnozstviVlny(vlna);
                        int den = Integer.parseInt(split[4]);
                        ovce.setDenNarozeni(den);
                        int mesic = Integer.parseInt(split[5]);
                        ovce.setMesicNarozeni(mesic);
                        int rok = Integer.parseInt(split[6]);
                        ovce.setRokNarozeni(rok);
                        seznam.pridej(ovce);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Zvirata byla uspesne nactena ze souboru");
    }

    private void vypisZvirata() {
        System.out.println("Výpis všech zvířat na farmě");
        System.out.println(" ");
        System.out.println(seznam.vypis());
    }

}
