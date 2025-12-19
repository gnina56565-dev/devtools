package ru.mentee.power.devtools.student;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    void testAddStudent() {
        StudentList list = new StudentList();
        Student student = new Student("Иван", "Москва");
        list.addStudent(student);
        assertEquals(1, list.getStudentsFromSpecificCity("Москва").size());
    }

    @Test
    void testGetStudentsFromSpecificCity() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Иван", "Москва"));
        list.addStudent(new Student("Мария", "Санкт-Петербург"));
        assertEquals(1, list.getStudentsFromSpecificCity("Москва").size());
        assertEquals(1, list.getStudentsFromSpecificCity("Санкт-Петербург").size());
    }
}