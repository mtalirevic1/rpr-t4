package ba.unsa.etf.rpr.tutorijal04;

import java.util.ArrayList;

public abstract class Predmet{
    private ArrayList<Student> studenti;
    private String naziv;
    private String profesor;
    private int brojECTS;

    Predmet(String naziv, String profesor, int brojECTS){
        this.naziv=naziv;
        this.profesor=profesor;
        this.brojECTS=brojECTS;
        studenti=new ArrayList<Student>();
    }

    public void upisiStudenta(Student student){
        for(Student s : studenti)
            if(s.getBrojIndeksa()==student.getBrojIndeksa()) return;
        studenti.add(student);
        student.dodajBodove(getBrojECTS());
    }

    public void obrisiStudenta(int index){
        for(int i = 0; i < studenti.size(); i++)
            if(studenti.get(i).getBrojIndeksa()==index){
                studenti.get(i).oduzmiBodove(getBrojECTS());
                studenti.remove(i);
                return;
            }

    }

    public String printStudents(){
        String result = new String();
        for(int i = 0; i < studenti.size(); i++)
            result = result + Integer.toString(i + 1) + ". " + studenti.get(i).toString() + "\n";
        return result;
    }

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
