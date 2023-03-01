package Practice.InterviewQuestion.Random;


/*
Q.1

Print the following String pattern

Input: sirius 2
Output: sius

Input: javadeveloper 3
output: javper

Input: laptop 1
output: lp
*/


import java.util.Scanner;

public class StringProblem1 {
    /**
     *
     * @param input
     * @param count
     */
    public static void stringOperation(String input,int count){
        char[] combo1 =  input.toCharArray();
        StringBuilder secondCombo = new StringBuilder();
        StringBuilder firstCombo = new StringBuilder();
        for(int i = 1;i<=combo1.length;i++){
           firstCombo.append(combo1[i - 1]);
           if(i==count){
               break;
           }
        }
        int countChar = 0;
        for(int i = combo1.length-1;i>=1;i--){
            countChar++;
            secondCombo.append(combo1[i]);
            if(countChar==count){
                break;
            }
        }
        System.out.println(firstCombo.append(secondCombo.reverse()));
    }

    //eliminated use of loop, used String and stringBuilder. Done
    public static void anotherStringOperation(String input,int count){
        StringBuilder rev = new StringBuilder(input);
        StringBuilder reverseTheString = rev.reverse();
        String getTheString = String.valueOf(reverseTheString).substring(0,count);
        StringBuilder lastReverse = new StringBuilder(getTheString);
        String backToString = String.valueOf(lastReverse.reverse());
        System.out.println(input.substring(0,count)+backToString);

    }
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the String");
        String input = enter.nextLine();
        System.out.println("Enter the count");
        int count = enter.nextInt();
        anotherStringOperation(input,count);





    }
}
