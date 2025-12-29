package ru.mentee.power.devtools.gate1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class MenteeGateTest {

    @Test
    @DisplayName("printFizzBuzz выводит Fizz, Buzz и FizzBuzz")
    void printFizzBuzzOutputsCorrectWords() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            MenteeGate.printFizzBuzz(15);
            String output = outContent.toString();
            assertThat(output).contains("Fizz");
            assertThat(output).contains("Buzz");
            assertThat(output).contains("FizzBuzz");
        } finally {
            System.setOut(originalOut);
        }
    }
}