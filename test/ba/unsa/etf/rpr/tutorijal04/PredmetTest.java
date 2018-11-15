package ba.unsa.etf.rpr.tutorijal04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {

    @Test
    void enrollStudent() {
        Predmet subject = new IzborniPredmet("MLTI", "Dikno Osmankovic", 7);
        Student student1 = new Student("Niko", "Nikic");
        student1.setBrojIndeksa(17825);
        Student student2 = new Student("Haso", "Hasic");
        student2.setBrojIndeksa(17696);
        subject.upisiStudenta(student1);
        subject.upisiStudenta(student2);
        assertEquals(2, subject.getStudenti().size());
        assertEquals(17825, (int) subject.getStudenti().get(0).getBrojIndeksa());
        assertEquals(17696, (int) subject.getStudenti().get(1).getBrojIndeksa());
        assertEquals(7, student1.getBrojECTS());
        assertEquals(7, student2.getBrojECTS());
    }

    @Test
    void deleteStudent() {
        Predmet subject = new IzborniPredmet("MLTI", "Dikno Osmankovic", 7);
        Student student1 = new Student("Niko", "Nikic");
        student1.setBrojIndeksa(17825);
        Student student2 = new Student("Haso", "Hasic");
        student2.setBrojIndeksa(17696);
        subject.upisiStudenta(student1);
        subject.upisiStudenta(student2);
        subject.obrisiStudenta(17825);
        assertEquals(0, student1.getBrojECTS());
        assertEquals(1, subject.getStudenti().size());
        assertEquals(17696, (int) subject.getStudenti().get(0).getBrojIndeksa());
    }

    @Test
    void printStudents() {
        Predmet subject = new IzborniPredmet("MLTI", "Dikno Osmankovic", 7);
        Student student1 = new Student("Niko", "Nikic");
        student1.setBrojIndeksa(17749);
        Student student2 = new Student("Meho", "Mehic");
        student2.setBrojIndeksa(17777);
        subject.upisiStudenta(student1);
        subject.upisiStudenta(student2);
        assertEquals("1. Niko Nikic 17749 7\n2. Meho Mehic 17777 7\n", subject.printStudents());
    }
}