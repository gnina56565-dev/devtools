package ru.mentee.power.devtools.gate1;

public class MenteeGate3 {
    public int findMax(int[] numbers){
        if (numbers.length == 0){
            throw new IllegalArgumentException();
        }
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        return max;
    }
    public static void main (String[] args){
        int arr2[] = {1,7,4,9};
        MenteeGate3 maximum = new MenteeGate3();
        System.out.println(maximum.findMax(arr2));
    }
}
