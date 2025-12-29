package ru.mentee.power.devtools.gate1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

class MenteeGate2Test {
    MenteeGate2 gate = new MenteeGate2();
    @Test
    @DisplayName("sumEven кратно двум")
    void sumEvenMultiply(){
        int[] arr1  = {1,2,3,4,5,6};
        int sum = gate.sumEven(arr1);
        assertThat(sum).isEqualTo(12);
    }

}