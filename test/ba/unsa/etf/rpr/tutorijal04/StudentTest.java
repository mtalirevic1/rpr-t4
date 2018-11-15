package ba.unsa.etf.rpr.tutorijal04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void increasePoints(){
        Student student = new Student("niko", "nikic");
        student.dodajBodove(5);
        assertEquals(5, student.getBrojECTS());
    }
    @Test
    void decreasePoints(){
        Student student = new Student("niko", "nikic");
        student.oduzmiBodove(5);
        assertEquals(-5, student.getBrojECTS());
    }
    @Test
    void _toString(){
        Student student = new Student("Niko", "Nikic");
        student.dodajBodove(5);
        student.setBrojIndeksa(17749);
        assertEquals("Niko Nikic 17749 5", student.toString());
    }
}