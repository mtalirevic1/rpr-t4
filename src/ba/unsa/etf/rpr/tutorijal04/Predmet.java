package ba.unsa.etf.rpr.tutorijal04;

import java.util.ArrayList;

public abstract class Predmet{
    private ArrayList<Student> studenti;
    private String naziv;
    private String profesor;
    private int brojECTS;

    Predmet(String naziv, String profesor, int brojECTS){}

    public ArrayList<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<Student> studenti) {
        this.studenti = studenti;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getBrojECTS() {
        return brojECTS;
    }

    public void setBrojECTS(int brojECTS) {
        this.brojECTS = brojECTS;
    }
}
