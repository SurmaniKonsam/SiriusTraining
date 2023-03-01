package Practice.InterviewQuestion.Random;

import java.util.Scanner;

public class SumOfDigitsReducedToOne {

    //Method (1)
    //This, also is doing fine.
    public static void enterNumber(int number){
        String catchNumber = ""+number;
        char[] numbers = catchNumber.toCharArray();
        int whetherSumOfDigitsIsLeftToOne = 0;
        for(char a: numbers){
            whetherSumOfDigitsIsLeftToOne = whetherSumOfDigitsIsLeftToOne + Integer.parseInt(String.valueOf(a));
        }
        //let's check the sum now
        String check = ""+whetherSumOfDigitsIsLeftToOne;
        if(check.length()==1){
            System.out.println("Output : "+check);
        }else{
            int checkSum = 0;
            char[] reiterate = check.toCharArray();
            for(char itr : reiterate){
                checkSum = checkSum + Integer.parseInt(String.valueOf(itr));
            }
            String secondCheck = ""+checkSum;
            if(secondCheck.length()==1){
                System.out.println("Output : "+secondCheck);
            }else{
                char[] secondItr = secondCheck.toCharArray();
                int secondCheckSum = 0;
                for(char sec: secondItr){
                    secondCheckSum = secondCheckSum+Integer.parseInt(String.valueOf(sec));
                }
                System.out.println("Output : "+secondCheckSum);
            }
        }
    }

    //Method (2)
    //yes this is doing fine
    public static void usingDoWhile(int number){
        String checkDigit = ""+number;
        String checkLength;
        if(checkDigit.length()==1){
            System.out.println("Output : "+checkDigit);
        }
        else {
            do {
                char[] intoChar = checkDigit.toCharArray();
                int sumOfDigits = 0;
                for (char c : intoChar) {
                    sumOfDigits = sumOfDigits + Integer.parseInt(String.valueOf(c));
                }
                checkLength = "" + sumOfDigits;
                checkDigit = null;
                checkDigit = ""+checkLength;

            }while(checkLength.length()!=1);

            System.out.println("Output : "+checkLength);
        }

    }

    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.println("Enter your number!!!");
        int number = enter.nextInt();
        enterNumber(number);

        System.out.println();
        System.out.println("________________");
        System.out.println();
        usingDoWhile(number);
    }
}
