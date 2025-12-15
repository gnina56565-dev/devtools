package ru.mentee.power.devtools.progress;

public class ProgressTracker {

    /**
     * Вычисляет суммарный прогресс группы mentee.
     *
     * @param mentees массив mentee
     * @return строка с информацией о суммарном прогрессе (пройдено/осталось уроков)
     */
    public String calculateTotalProgress(Mentee[] mentees) {
        // TODO: Реализовать логику подсчёта суммарного прогресса с использованием цикла while
        // Шаги:
        // 1. Проверить валидность массива (null, пустой)
        if (mentees == null) {
            return "Ок";
        }
        // 2. Инициализировать аккумуляторы: totalCompleted = 0, totalTotal = 0, index = 0
        int totalCompleted = 0;
        int totalTotal = 0;
        int index = 0;
        // 3. Использовать цикл while (index < mentees.length) для перебора массива
        while (index < mentees.length){
            totalCompleted += mentees[index].completedLessons();
            totalTotal += mentees[index].totalLessons();
            index++;
        }
        int totalRemaining = totalTotal - totalCompleted;
        return "пройдено " + totalCompleted + " из " + totalTotal + " уроков осталось " + totalRemaining + " уроков";
        // 4. На каждой итерации: totalCompleted += mentees[index].completedLessons(), totalTotal += mentees[index].totalLessons(), index++
        // 5. Вычислить оставшиеся: totalRemaining = totalTotal - totalCompleted
        // 6. Вернуть строку формата: "Суммарно: пройдено X из Y уроков, осталось Z уроков"
    }

    public static void main(String[] args) {
        ProgressTracker tracker = new ProgressTracker();

        // Создаём массив mentee (продолжение DVT-2: добавляем прогресс к личной карточке)
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String progress = tracker.calculateTotalProgress(mentees);
        System.out.println(progress);
    }
}