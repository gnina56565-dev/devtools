package ru.mentee.power.devtools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import ru.mentee.power.MenteeProgress; // ← Это ключевая строка!

class MenteeProgressTest {

    @Test
    @DisplayName("Должен создавать корректную строку summary")
    void shouldCreateCorrectSummary() {
        MenteeProgress progress = new MenteeProgress("Иван Петров", 2, 6);
        String result = progress.summary();
        assertThat(result).isEqualTo("Sprint 2: Иван Петров (planned 6 h)");
    }

    @Test
    @DisplayName("Должен корректно работать с нулевым номером спринта")
    void shouldHandleZeroSprintNumber() {
        MenteeProgress progress = new MenteeProgress("Ирина", 0, 5);
        String result = progress.summary();
        assertThat(result).isEqualTo("Sprint 0: Ирина (planned 5 h)");
    }

    @Test
    @DisplayName("readyForSprint должен возвращать true при plannedHoursPerWeek >= 3")
    void shouldBeReadyForSprintWhenHoursSufficient() {
        assertThat(new MenteeProgress("Анна", 1, 3).readyForSprint()).isTrue();
        assertThat(new MenteeProgress("Петр", 1, 10).readyForSprint()).isTrue();
        assertThat(new MenteeProgress("Мария", 1, 2).readyForSprint()).isFalse();
    }

    @Test
    @DisplayName("readyForSprint должен возвращать false при plannedHoursPerWeek < 3")
    void shouldNotBeReadyForSprintWhenHoursInsufficient() {
        assertThat(new MenteeProgress("Сергей", 1, 2).readyForSprint()).isFalse();
        assertThat(new MenteeProgress("Ольга", 1, 0).readyForSprint()).isFalse();
    }

    @Test
    @DisplayName("Должен обрабатывать пустое имя студента")
    void shouldHandleEmptyMenteeName() {
        MenteeProgress progress = new MenteeProgress("", 1, 5);
        String result = progress.summary();
        assertThat(result).isEqualTo("Sprint 1:  (planned 5 h)");
    }

    @Test
    @DisplayName("record должен корректно хранить данные")
    void recordShouldStoreDataCorrectly() {
        MenteeProgress progress = new MenteeProgress("Алексей", 3, 8);
        assertThat(progress.menteeName()).isEqualTo("Алексей");
        assertThat(progress.sprintNumber()).isEqualTo(3);
        assertThat(progress.plannedHoursPerWeek()).isEqualTo(8);
    }
}