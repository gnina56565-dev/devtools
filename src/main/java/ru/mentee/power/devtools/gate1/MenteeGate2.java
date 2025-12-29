package ru.mentee.power.devtools.gate1;

public class MenteeGate2 {
    public int sumEven(int[] numbers){
        int sum = 0;
        for (int num : numbers){
            if(num % 2 == 0){
                sum += num;
            }
        }
        return sum;
    }
    public static void main (String[] args){
        MenteeGate2 MenteeG = new MenteeGate2();
        int arr1[] = {1,2,3,4,5,6};
        System.out.println(MenteeG.sumEven(arr1));
    }
}
