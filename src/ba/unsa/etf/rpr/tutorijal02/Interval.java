package ba.unsa.etf.rpr.tutorijal02;
/*
isNull koja vraća boolean vrijednost da li je interval null interval ili nije;
isIn metoda koja prima vrijednost tačke (tipa double) i vraća da li tačka pripada intervalu;
metodu intersect koja vraća presjek dva intervala: metoda treba biti urađena kao klasična public metoda prima jedan interval) i kao statička metoda (prima dva intervala);
također treba preklopiti metode klase Object a to su toString i equals, na način koji ima smisla za te metode.

*/
public class Interval {
    private double pocetnaTacka,krajnjaTacka;
    boolean pripadnostPocetne,pripadnostKrajnje;

    public Interval(double pocetnaTacka,double krajnjaTacka,boolean pripadnostPocetne,boolean pripadnostKrajnje){
        if(pocetnaTacka>krajnjaTacka){
            throw IllegalArgumentException;
        }
        this.pocetnaTacka=pocetnaTacka;
        this.krajnjaTacka=krajnjaTacka;
        this.pripadnostPocetne=pripadnostPocetne;
        this.pripadnostKrajnje=pripadnostKrajnje;
    }

    public Interval(){
        pocetnaTacka=0;
        krajnjaTacka=0;
        pripadnostPocetne=false;
        pripadnostKrajnje=false;
    }

    public boolean isNull() {
        if (pocetnaTacka == 0 && krajnjaTacka == 0 && pripadnostPocetne = false && pripadnostKrajnje = false) {
            return true;
        }
        return false;
    }

    public boolean isIn(double tacka) {

        if (pripadnostPocetne) {
            if (tacka < pocetnaTacka) {
                return false;
            }
        }
        if (pripadnostKrajnje) {
            if (tacka > krajnjaTacka) {
                return false;
            }
        }
        if (tacka <= pocetnaTacka) {
            return false;
        }
        if (tacka >= krajnjaTacka) {
            return false;
        }
        return true;
    }




}
