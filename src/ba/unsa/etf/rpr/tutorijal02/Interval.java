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

    public Interval (Interval interval) { //konstruktor koji prima objekat tipa Interval
        this (interval.pocetnaTacka,interval.krajnjaTacka,interval.pripadnostPocetne,interval.pripadnostKrajnje);
    }


    public boolean isNull() {
        if (pocetnaTacka == 0 && krajnjaTacka == 0 && pripadnostPocetne = false && pripadnostKrajnje = false) {
            return true;
        }
        return false;
    }

    public boolean isIn(double tacka) {
        if(pripadnostPocetne && tacka==this.pocetnaTacka){
            return true;
        }
        if(pripadnostKrajnje && tacka==this.krajnjaTacka){
            return true;
        }
        if(tacka>this.pocetnaTacka && tacka<this.krajnjaTacka){
            return true;
        }
        return false;
    }

    public Interval intersect(Interval interval) {

        if (this.isIn(interval.pocetnaTacka) && this.isIn(interval.krajnjaTacka)) { //slucaj kada interval u potpunosti pripada drugomintervalu;
            Interval presjek=new Interval(interval);
            return presjek;
        }

        if (this.isIn(interval.pocetnaTacka)) {
            Interval presjek=new Interval(interval.pocetnaTacka,this.krajnjaTacka, interval.pripadnostPocetne,this.pripadnostKrajnje);
            return presjek;
        }

        if (this.isIn(interval.krajnjaTacka)) {
            Interval presjek=new Interval(this.pocetnaTacka,interval.krajnjaTacka, this.pripadnostPocetne,interval.pripadnostKrajnje);
            return presjek;
        }
    }




    }





