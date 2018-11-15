package ba.unsa.etf.rpr.tutorijal04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

class SemestarTest {
    Semestar semester = null;
    @BeforeEach
    void init(){
        ArrayList<Tuple<String, String, Integer, Class>> subjects = new ArrayList<>();
        subjects.add(new Tuple<>("Razvoj programskih rjesenja", "Vedran Ljubovic", 5, ObavezniPredmet.class));
        subjects.add(new Tuple<>("Diskretna matematika", "Zeljko Juric", 5, ObavezniPredmet.class));
        subjects.add(new Tuple<>("Logicki dizajn", "Novica Nosovic", 5, ObavezniPredmet.class));
        subjects.add(new Tuple<>("Algoritmi i strukture podataka", "Haris Supic", 5, ObavezniPredmet.class));
        subjects.add(new Tuple<>("Osnove baza podataka", "Emir Buza", 5, ObavezniPredmet.class));
        subjects.add(new Tuple<>("Sistemsko programiranje", "Samir Ribic", 5, IzborniPredmet.class));
        subjects.add(new Tuple<>("Numericki algoritmi", "Zeljko Juric", 5, IzborniPredmet.class));
        assertDoesNotThrow(() -> semester = new Semestar(subjects));
    }
    public Semestar getSemestar(){ return this.semester; }
    @Test
    void getElectoralSubjects() {
        assertEquals("1. Predmet name: Sistemsko programiranje, Responsible teacher: Samir Ribic, ECTS: 5\n" +
                "2. Predmet name: Numericki algoritmi, Responsible teacher: Zeljko Juric, ECTS: 5\n", semester.getIzbornePredmete());
    }

    @Test
    void getObligatorySubjects() {
        assertEquals("1. Predmet name: Razvoj programskih rjesenja, Responsible teacher: Vedran Ljubovic, ECTS: 5\n" +
                "2. Predmet name: Diskretna matematika, Responsible teacher: Zeljko Juric, ECTS: 5\n" +
                "3. Predmet name: Logicki dizajn, Responsible teacher: Novica Nosovic, ECTS: 5\n" +
                "4. Predmet name: Algoritmi i strukture podataka, Responsible teacher: Haris Supic, ECTS: 5\n" +
                "5. Predmet name: Osnove baza podataka, Responsible teacher: Emir Buza, ECTS: 5\n", semester.getObaveznePredmete());
    }


    @Test
    void enrollStudent() {
        ArrayList<String> electoral1 = new ArrayList<>();
        electoral1.add("Sistemsko programiranje");
        ArrayList<String> electoral2 = new ArrayList<>();
        electoral2.add("Numericki algoritmi");
        Student student1 = new Student("Niko", "Nikic");
        Student student2 = new Student("Haso", "Hasic");
        assertDoesNotThrow(() -> semester.upisiStudenta(student1, electoral1));
        assertDoesNotThrow(() -> semester.upisiStudenta(student2, electoral2));
        assertEquals(30, student1.getBrojECTS());
        Student student = new Student("Ime", "Prezime");
        assertThrows(IllegalArgumentException.class , () ->semester.upisiStudenta(student, null));
        assertThrows(IllegalECTSException.class, () -> semester.upisiStudenta(student, new ArrayList<>()));
    }

    @BeforeEach
    void init2(){
        ArrayList<String> electoral1 = new ArrayList<>();
        electoral1.add("Sistemsko programiranje");
        ArrayList<String> electoral2 = new ArrayList<>();
        electoral2.add("Numericki algoritmi");
        try{
            semester.upisiStudenta(new Student("Niko", "Nikic"), electoral1);
            semester.upisiStudenta(new Student("Huso", "Husic"), electoral2);
        }
        catch (IllegalArgumentException e) { }
        catch (IllegalECTSException e) { }
    }
    @Test
    void deleteStudent() {
        semester.deleteStudent(semester.getStudenti().get(1).getBrojIndeksa());
        assertEquals(1, semester.getStudenti().size());
        assertEquals("1. Niko Nikic " + semester.getStudenti().get(0).getBrojIndeksa()+ " 30\n", semester.getPredmeti().get(5).printStudents());
    }

    @Test
    void addSubject() {
        semester.addPredmet(new IzborniPredmet("predmet", "profesor", 20));
        assertEquals("predmet", semester.getPredmeti().get(semester.getPredmeti().size() - 1).getNaziv());
    }



}