package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenteeTest {
    @Test
    void WhenCompleteLessonNegative () {
        assertThrows(IllegalArgumentException.class, () -> {
            new Mentee("Имя", "Город", "Цель", 10, -5);
        });
    }
    @Test
    void WhenCompleteZeroLesson () {
        assertThrows(IllegalArgumentException.class, () -> {
            new Mentee("Ваня", "Москва", "5", 0, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Mentee("Соня", "Самара", "0", -1, 0);
        });
    }
    @Test
    void WhenCompleteTotal() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Mentee("Ида", "Сочи", "5", 10, 5);
        });
    }
}
