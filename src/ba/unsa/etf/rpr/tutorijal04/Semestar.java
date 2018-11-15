package ba.unsa.etf.rpr.tutorijal04;

import java.util.ArrayList;

public class Semestar {
    public ArrayList<Student> getStudenti() {
        return studenti;
    }

    public ArrayList<Predmet> getPredmeti() {
        return predmeti;
    }

    private ArrayList<Student> studenti =  new ArrayList<>();
    private ArrayList<Predmet> predmeti = new ArrayList<>();
    Integer indexCounter = 15000;
    public Semestar(ArrayList<Tuple<String, String, Integer, Class>> predmeti)throws IllegalArgumentException, IllegalECTSException{
        if(predmeti == null) throw new IllegalArgumentException();
        int sum = 0;
        ArrayList<Predmet> newpredmeti = new ArrayList<>();
        for(Tuple<String, String, Integer, Class> t : predmeti) {
            sum += t.getItem3();
            if(t.getItem4() == ObavezniPredmet.class)
                newpredmeti.add(new ObavezniPredmet(t.getItem1(), t.getItem2(), t.getItem3()));
            else newpredmeti.add(new IzborniPredmet(t.getItem1(), t.getItem2(), t.getItem3()));
        }
        if(sum < 30) throw new IllegalECTSException("");
        this.predmeti = newpredmeti;
    }

    public String getElectoralpredmeti(){
        String result = new String();
        int i = 1;
        for(Predmet s : this.predmeti){
            if(s instanceof IzborniPredmet){
                result += Integer.toString(i) + ". Predmet name: " + s.getNaziv() + ", Responsible teacher: "
                        + s.getProfesor() + ", ECTS: " + Integer.toString(s.getBrojECTS()) + "\n";
                i++;
            }
        }
        return result;
    }
    public String getObaveznePredmete(){
        String result = new String();
        int i = 1;
        for(Predmet s : this.predmeti){
            if(s instanceof ObavezniPredmet){
                result += Integer.toString(i) + ". Predmet name: " + s.getNaziv() + ", Responsible teacher: "
                        + s.getProfesor() + ", ECTS: " + Integer.toString(s.getBrojECTS()) + "\n";
                i++;
            }
        }
        return result;
    }
    public void enrollStudent(Student student, ArrayList<String> electoralpredmeti) throws IllegalECTSException, IllegalArgumentException{
        if(student == null || electoralpredmeti == null) throw new IllegalArgumentException();
        boolean ima = false;
        for(String electoral : electoralpredmeti) {
            ima = false;
            for (Predmet s : this.predmeti) {
                if (electoral.equalsIgnoreCase(s.getNaziv())){
                    ima = true;
                    break;
                }
            }
            if(!ima) throw new IllegalArgumentException();
        }
        for(Predmet s : this.predmeti){
            if(s instanceof ObavezniPredmet) s.upisiStudenta(student);
            else {
                for(String electoral : electoralpredmeti)
                    if(electoral.equalsIgnoreCase(s.getNaziv())){
                        s.upisiStudenta(student);
                        break;
                    }
            }
        }
        this.studenti.add(student);
        student.setBrojIndeksa(this.indexCounter++);
        if(student.getBrojECTS() < 30){
            student.setBrojIndeksa(0);
            this.indexCounter--;
            deleteStudent(student.getBrojIndeksa());

            throw new IllegalECTSException("");
        }
    }
    public void deleteStudent(Integer index){
        for(Predmet Predmet : this.predmeti)
            Predmet.obrisiStudenta(index);
        for(int i = 0; i < this.studenti.size(); i++){
            if(this.studenti.get(i).getBrojIndeksa()==index){
                this.studenti.remove(i);
                return;
            }
        }
    }
    public void addPredmet(Predmet predmet){
        for(Predmet s : this.predmeti)
            if(s.getNaziv().equalsIgnoreCase(predmet.getNaziv()))
                throw new IllegalArgumentException();
        this.predmeti.add(predmet);
    }
    public void deletePredmet(String PredmetName){
        Predmet Predmet = null;
        for(Predmet s : this.predmeti)
            if(s.getNaziv().equalsIgnoreCase(PredmetName)){
                Predmet = s;
                break;
            }
        if(Predmet == null) throw new IllegalArgumentException();
        this.predmeti.remove(Predmet);
        for(int i = 0; i < studenti.size(); i++){
            Predmet.obrisiStudenta(studenti.get(i).getBrojIndeksa());
            if(studenti.get(i).getBrojECTS() < 30){
                deleteStudent(studenti.get(i).getBrojIndeksa());
                i--;
            }
        }
    }
}
