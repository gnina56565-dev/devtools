package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


@DisplayName("Тестирование ProgressTracker")
class ProgressLoopTest {
    @Test
    @DisplayName("Должен корректно вычислить суммарный прогресс когда передан массив mentee")
    void shouldCalculateTotalProgress_whenMultipleMentees() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 25 из 36 уроков")
                .contains("осталось 11 уроков");
    }

    @Test
    void shouldReturnOkWhenMenteesIsNull() {
        ProgressTracker tracker = new ProgressTracker();
        String result = tracker.calculateTotalProgress(null);
        assertEquals("Ok", result);
    }

    //покрытие main тестом
    @Test
    void shouldExecuteMainMethod() {
        // Перехватываем вывод
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            ProgressTracker.main(new String[]{});
            String output = outContent.toString().trim();
            assertTrue(output.contains("пройдено 25 из 36 уроков"), "Ожидаемый текст не найден");
            assertTrue(output.contains("осталось 11 уроков"), "Ожидаемый текст не найден");
        } finally {
            System.setOut(originalOut);
        }
    }
}