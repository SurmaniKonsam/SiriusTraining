package Practice.InterviewQuestion.Random;

import java.util.Scanner;

/*
5. Write a program using switch case to create a Calculator

Input: add 5 10
Output: 15

Input: multiply 2 7
Output: 14
*/

public class CalculatorUsingSwitchCase {
    /**
     *
     */
    public static void anotherCalculator(){
        Scanner enter = new Scanner(System.in).useDelimiter("\n");
        int result;
        int grab;
        System.out.println("Enter number");
        int firstNum = enter.nextInt();
        System.out.print("\\  *  +  -  %  null\n");
        System.out.println("Choose one");
        String choice = enter.next();
        do {
            switch (choice) {
                case "\\" -> {
                    System.out.println("Enter number");
                    grab = enter.nextInt();
                    result = firstNum / grab;
                    System.out.println("divided result : " + result);
                    firstNum = result;
                    System.out.print("\\  *  +  -  %  null\n");
                    System.out.println("Choose one");
                    choice = enter.next();
                }
                case "*" -> {
                    System.out.println("Enter number");
                    grab = enter.nextInt();
                    result = firstNum * grab;
                    System.out.println("product : " + result);
                    firstNum = result;
                    System.out.print("\\  *  +  -  %  null\n");
                    System.out.println("Choose one");
                    choice = enter.next();
                }
                case "+" -> {
                    System.out.println("Enter number");
                    grab = enter.nextInt();
                    result = firstNum + grab;
                    System.out.println("sum : " + result);
                    firstNum = result;
                    System.out.print("\\  *  +  -  %  null\n");
                    System.out.println("Choose one");
                    choice = enter.next();
                }
                case "-" -> {
                    System.out.println("Enter number");
                    grab = enter.nextInt();
                    result = firstNum - grab;
                    System.out.println("difference : " + result);
                    firstNum = result;
                    System.out.print("\\  *  +  -  %  null\n");
                    System.out.println("Choose one");
                    choice = enter.next();
                }

                case "%" ->{
                    System.out.println("Enter number");
                    grab = enter.nextInt();
                    result = firstNum % grab;
                    System.out.println("remainder : " + result);
                    firstNum = result;
                    System.out.print("\\  *  +  -  %  null\n");
                    System.out.println("Choose one");
                    choice = enter.next();
                }

                case "null" -> choice = "null";

                default -> {
                    System.out.println("no such operator available!!!");
                    choice = "null";
                }
            }
        }while(!choice.equals("null"));

    }
    public static void main(String[] args) {
        anotherCalculator();
    }
}
