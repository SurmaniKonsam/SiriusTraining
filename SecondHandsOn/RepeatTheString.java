package Practice.InterviewQuestion.Random;

import java.util.Arrays;
/*
Q.2

Write a program to print the following String pattern
Input: a3b10c4
Output: aaabbbbbbbbbbcccc

*/
public class RepeatTheString {
    /**
     *
     * @param input
     */
    //First method
    //.done
    public static void takeString(String input){
        String[] splitTheStringBasedOnNumber = input.split("[0-9]+");
        String[] splitTheStringBasedOnChar  = input.split("[a-zA-Z]+");
        for(int i = 0;i<splitTheStringBasedOnNumber.length;i++){
            int count = 0;
            while(count<Integer.parseInt(splitTheStringBasedOnChar[i+1])){
                System.out.print(splitTheStringBasedOnNumber[i]);
                count++;
            }
        }
    }
    public static void main(String[] args) {
        takeString("a34b7c3");
    }
}
