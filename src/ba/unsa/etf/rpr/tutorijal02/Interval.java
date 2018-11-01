package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    boolean pripadnostPocetne, pripadnostKrajnje;
    private double pocetnaTacka, krajnjaTacka;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pripadnostPocetne, boolean pripadnostKrajnje) {
        if(pocetnaTacka>krajnjaTacka) {
            throw new IllegalArgumentException();
        }
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pripadnostPocetne = pripadnostPocetne;
        this.pripadnostKrajnje = pripadnostKrajnje;
    }

    public Interval() {
        pocetnaTacka = 0;
        krajnjaTacka = 0;
        pripadnostPocetne = false;
        pripadnostKrajnje = false;
    }

    public Interval(Interval interval) { //konstruktor koji prima objekat tipa Interval
        this(interval.pocetnaTacka, interval.krajnjaTacka, interval.pripadnostPocetne, interval.pripadnostKrajnje);
    }

    public static Interval intersect(Interval i, Interval j) {
        Interval presjek = new Interval(i.intersect(j));
        return presjek;
    }

    public boolean isNull() {
        if ((pocetnaTacka == 0 && krajnjaTacka == 0) && (pripadnostPocetne == false && pripadnostKrajnje == false)) {
            return true;
        }
        return false;
    }

    public boolean isIn(double tacka) {
        if (pripadnostPocetne && tacka == this.pocetnaTacka) {
            return true;
        }
        if (pripadnostKrajnje && tacka == this.krajnjaTacka) {
            return true;
        }
        if (tacka > this.pocetnaTacka && tacka < this.krajnjaTacka) {
            return true;
        }
        return false;
    }

    public Interval intersect(Interval interval) {

        if (this.isIn(interval.pocetnaTacka) && this.isIn(interval.krajnjaTacka)) { //slucaj kada interval u potpunosti pripada drugom intervalu;
            Interval presjek = new Interval(interval);
            return presjek;
        }

        if (this.isIn(interval.pocetnaTacka)) {
            Interval presjek = new Interval(interval.pocetnaTacka, this.krajnjaTacka, interval.pripadnostPocetne, this.pripadnostKrajnje);
            return presjek;
        }

        if (this.isIn(interval.krajnjaTacka)) {
            Interval presjek = new Interval(this.pocetnaTacka, interval.krajnjaTacka, this.pripadnostPocetne, interval.pripadnostKrajnje);
            return presjek;
        }

        Interval presjek = new Interval(); // ako nema presjeka vraca "null" skup;
        return presjek;
    }

    public String toString() {
        if (this.isNull()) {
            return "()";
        }
        String s = new String();
        if (pripadnostPocetne) {
            s = "[";
        } else {
            s = "(";
        }
        s = s + this.pocetnaTacka + "," + this.krajnjaTacka;

        if (pripadnostKrajnje) {
            s = s + "]";
        } else {
            s = s + ")";
        }
        return s;
    }

    public boolean equals(Interval i){
        if(this.pocetnaTacka==i.pocetnaTacka && this.krajnjaTacka==i.krajnjaTacka && this.pripadnostPocetne==i.pripadnostPocetne && this.pripadnostKrajnje==i.pripadnostKrajnje)
            return true;
        else
            return false;
    }


}





