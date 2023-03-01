package Practice.InterviewQuestion.Random;

import java.util.Scanner;

public class ArmstrongNumber {
    int remainder = 0,sum = 0;

    //will calculate power
    public int calculatePower(int number){
        int count = 0;
        while(number!=0){
            count++;
            number = number/10;
        }
        return count;
    }

    //First method
    public void armstrongNumber(int number){
        int power = this.calculatePower(number);
        int compare = number;
        while(number!=0){
            remainder = number%10;
            sum = sum + (int)Math.pow(remainder,power);
            number = number/10;
        }
        if(compare == sum){
            System.out.println(compare+" is an armstrong number!!!");
        }
        else{
            System.out.println(compare+" is not armstrong number");
        }
    }

    //second method
    public void anotherWayToArmstrong(int number){
        int sum = 0;
        String ourNumber = ""+number;
        int power = this.calculatePower(number);
        char[] numberSegregated = ourNumber.toCharArray();
        for(char a: numberSegregated){
            sum = sum + (int)Math.pow((Integer.parseInt(String.valueOf(a))),power);
        }
        if(sum==number){
            System.out.println(number+" is an armstrong number!!!");
        }else{
            System.out.println(number+" is not an armstrong number!!!");
        }
    }

    public static void main(String[] args) {
        ArmstrongNumber obj = new ArmstrongNumber();
        Scanner enterNumber = new Scanner(System.in);
        System.out.println("Enter your number");
        int enter = enterNumber.nextInt();
        obj.armstrongNumber(enter);
        System.out.println();
        obj.anotherWayToArmstrong(enter);


    }
}