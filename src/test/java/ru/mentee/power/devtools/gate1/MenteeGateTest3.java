package ru.mentee.power.devtools.gate1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

class MenteeGateTest3 {
    private final MenteeGate3 gate = new MenteeGate3();

    @Test
    @DisplayName("findMax: массив {3, 7, 2, 9, 1} → 9")
    void findMaxNormalArrayReturnsMax() {
        int[] input = {3, 7, 2, 9, 1};
        int result = gate.findMax(input);
        assertThat(result).isEqualTo(9);
    }
    @Test
    @DisplayName("findMax пустой массив")
    void findMaxNullArray(){
        int[] input = {};
        assertThatThrownBy(() -> gate.findMax(input)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("findMax массив с отрицательными числами")
    void FindMaxNegativeNumbers(){
        int[] input = {-5, -1, -2, -7};
        int result = gate.findMax(input);
        assertThat(result).isEqualTo(-1);
    }
    @Test
    @DisplayName("findMax массив с одним числом")
    void FindMaxOneNumberArray (){
        int[] input = {52};
        int result = gate.findMax(input);
        assertThat(result).isEqualTo(52);
    }

}