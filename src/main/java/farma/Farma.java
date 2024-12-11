package farma;

/**
 * Cvičení 8 - Farma
 *
 * Bude procvičeno dědění, abstraktní třída a rozhraní. Bude využit polymorfismus
 * https://www.algoritmy.net/article/23665/Dedicnost-12 a substituční princip
 * https://cs.wikipedia.org/wiki/Liskovov%C3%A9_princip_zastoupen%C3%AD.
 *
 * <pre>
 * Slovní zadání:
 *
 * Naprogramujte aplikaci Farma, která umožní spravovat seznam zvířat. Správou
 * se rozumí vkládání a odebírání zvířat ze seznamu. Seznam zvířat musí umět
 * sestavit textovou zprávu se všemi zvířaty, kdy každé zvíře bude na novém
 * řádku. Textová zpráva bude obsahovat na jednotlivých řádcích typ, jméno
 * zvířat a zvuk, který zvíře umí. Zvířata budou tři a to pes, kočka a kůň.
 * 
 * 
 * Implementační požadavky
 * 
 * 1. Ve třídě Farma mějte jen metodu main, která si vytvoří seznam zvířat.
 * 2. Referenci na instanci seznamu zvířat uložte do proměnné typu Seznam.
 * 3. Z metody main volejte metody, které jsou deklarovány v interfejsu Seznam,
 *    kterými ověříte funkčnost seznamu zvířat.
 * 4. Všechny třídy, které se týkají zvířat, mějte v samostatném balíčku "zvirata".
 *
 * </pre>
 */

public class Farma {

    private static final int MAX_POCET_ZVIRAT = 1000;

    public static void main(String[] args) {
        try {
            int kapacita = MAX_POCET_ZVIRAT;
            if (args.length > 0) {
                kapacita = Integer.parseInt(args[0]);
                if (kapacita > MAX_POCET_ZVIRAT) {
                    System.out.println("Překročen maximální počet zvířat!");
                    System.exit(111);
                }
            }
            new Command(kapacita).run();
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("Chyba ve formátu čísla!");
            System.exit(112);
        } catch (NullPointerException e) {
            System.out.println("Chyba s nullem!");
            System.exit(113);
        }
    }
}
