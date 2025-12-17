package ru.mentee.power.devtools;

public class ProgressDemo {
    public static void main(String[] args) {
        var progress = new MenteeProgress(
                "Имя студента", // возьми значение из своего плана DVT-0
                1,               // номер спринта
                6                // запланированные часы на спринт
        );

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}