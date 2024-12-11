
package farma;

import farma.zvirata.Zvire;

/**
 *
 * @author karel@simerda.cz
 */
public interface Seznam {

    Zvire odeber(int pozice);

    void pridej(Zvire zvire);
    
    default void pridej(Zvire... zvirata) {
        for(Zvire zvire: zvirata) {
            pridej(zvire);
        }
    }

    String vydejZvuky();

    String vypis();

    void nastavPrvni();

    Zvire dejDalsi();

    void zrus();
    
}
