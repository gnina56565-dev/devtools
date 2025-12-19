package ru.mentee.power.devtools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MenteeProgressTest {

    @Test
    @DisplayName("Должен создавать корректную строку summary")
    void shouldCreateCorrectSummary() {
        // Arrange
        MenteeProgress progress = new MenteeProgress("Иван Петров", 2, 6);

        // Act
        String result = progress.summary();

        // Assert
        assertThat(result).isEqualTo("Sprint 2 → Иван Петров: planned 6 h");
    }

    @Test
    @DisplayName("Должен корректно работать с нулевым номером спринта")
    void shouldHandleZeroSprintNumber() {
        // Arrange
        MenteeProgress progress = new MenteeProgress("Ирина", 0, 5);

        // Act
        String result = progress.summary();

        // Assert
        assertThat(result).isEqualTo("Sprint 0 → Ирина: planned 5 h");
    }

    @Test
    @DisplayName("readyForSprint должен возвращать true при plannedHoursPerWeek >= 3")
    void shouldBeReadyForSprintWhenHoursSufficient() {
        // Arrange
        MenteeProgress progress1 = new MenteeProgress("Анна", 1, 3);
        MenteeProgress progress2 = new MenteeProgress("Петр", 1, 10);
        MenteeProgress progress3 = new MenteeProgress("Мария", 1, 2);

        // Act & Assert
        assertThat(progress1.readyForSprint()).isTrue();   // ровно 3 часа
        assertThat(progress2.readyForSprint()).isTrue();   // больше 3 часов
        assertThat(progress3.readyForSprint()).isFalse();  // меньше 3 часов
    }

    @Test
    @DisplayName("readyForSprint должен возвращать false при plannedHoursPerWeek < 3")
    void shouldNotBeReadyForSprintWhenHoursInsufficient() {
        // Arrange
        MenteeProgress progress1 = new MenteeProgress("Сергей", 1, 2);
        MenteeProgress progress2 = new MenteeProgress("Ольга", 1, 0);

        // Act & Assert
        assertThat(progress1.readyForSprint()).isFalse();
        assertThat(progress2.readyForSprint()).isFalse();
    }

    @Test
    @DisplayName("Должен обрабатывать пустое имя студента")
    void shouldHandleEmptyMenteeName() {
        // Arrange
        MenteeProgress progress = new MenteeProgress("", 1, 5);

        // Act
        String result = progress.summary();

        // Assert
        assertThat(result).isEqualTo("Sprint 1 → : planned 5 h");
    }

    @Test
    @DisplayName("record должен корректно хранить данные")
    void recordShouldStoreDataCorrectly() {
        // Arrange
        MenteeProgress progress = new MenteeProgress("Алексей", 3, 8);

        // Assert
        assertThat(progress.menteeName()).isEqualTo("Алексей");
        assertThat(progress.sprintNumber()).isEqualTo(3);
        assertThat(progress.plannedHoursPerWeek()).isEqualTo(8);
    }
    @Test
    void shouldReturnTrueWhenPlannedHoursIsExactly3() {
        MenteeProgress p = new MenteeProgress("А", 1, 3);
        assertTrue(p.readyForSprint());
    }
    @Test
    void shouldReturnFalseWhenPlannedHoursIs0() {
        MenteeProgress p = new MenteeProgress("Б", 1, 0);
        assertFalse(p.readyForSprint());
    }
}