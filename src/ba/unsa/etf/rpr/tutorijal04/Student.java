package ba.unsa.etf.rpr.tutorijal04;

public class Student {
    private String ime;
    private String prezime;
    private int brojIndeksa;
    private int brojECTS=0;

    Student(String ime, String prezime){
        this.ime=ime;
        this.prezime=prezime;
    }

    public void dodajBodove(int bodovi){
        brojECTS+=bodovi;
    }

    public void oduzmiBodove(int bodovi){
        brojECTS-=bodovi;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(int brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public int getBrojECTS() {
        return brojECTS;
    }

    public void setBrojECTS(int brojECTS) {
        this.brojECTS = brojECTS;
    }

    @Override
    public String toString() {
        return getIme() + " " + getPrezime() + " " + Integer.toString(getBrojIndeksa()) + " " + Integer.toString(getBrojECTS());
    }
}
