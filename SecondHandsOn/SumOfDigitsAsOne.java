package Practice.InterviewQuestion.Random;

import java.util.Scanner;

/*
Q.4

Find the sum of the digits with the given format

Input: 2520
Output: 72

In the above Examples take first and last digit and append it to form 20
Also take second digit from front and last and append it to form 52
Now add 52 + 20

Input: 17296
Output: 97

In the above split 16 + 79 + 2 = 97

Note: Use Functions to Code this problem

*/
public class SumOfDigitsAsOne {
    public static void anotherWay(int number){
        String num = ""+number;
        char[] onion = num.toCharArray();
        System.out.println("Input : "+num);
        int sum = 0;
        int midSection = onion.length/2;
        int lastIndex = onion.length-1;
        if(onion.length%2!=0){
            for(int i = 0;i<midSection;i++){
                for(int j = lastIndex;j>(lastIndex)-1;j--){
                    if(j==midSection){
                        break;
                    }
                    String app = ""+onion[i]+onion[j];
                    sum = sum+Integer.parseInt(app);
                    System.out.println(app);
                }
                lastIndex--;
            }
            System.out.println("mid section element : "+onion[midSection]);
            sum = sum+Integer.parseInt(String.valueOf(onion[midSection]));
        }
        else{
            for(int i = 0;i<=midSection-1;i++){
                for(int j = lastIndex;j>(lastIndex)-1;j--){
                    String app = ""+onion[i]+onion[j];
                    sum = sum+Integer.parseInt(app);
                    System.out.println(app);
                }
                lastIndex--;
            }
        }
        System.out.println("Output : "+sum);
    }

    //done.
    //inner loop eliminated
    //used same code for both even and odd.
    public static void anotherApproach(int number){
        String num = ""+number;
        char[] onion = num.toCharArray();
        System.out.println("Input : "+num);
        int sum = 0;
        int j = onion.length-1;
        for(int i = 0;i<onion.length;i++){
            if(i==onion.length/2){
                break;
            }
            if(i+j==(onion.length-1)){
                String app = ""+onion[i]+onion[j];
                System.out.println(app);
                sum = sum+Integer.parseInt(app);
                j--;
            }
        }
        if(onion.length%2!=0){
            int i = Integer.parseInt(String.valueOf(onion[onion.length / 2]));
            System.out.println(i);
            sum = sum+ i;
            System.out.println("Output : "+sum);
        }else{
            System.out.println("Output : "+sum);
        }
    }

    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.println("Enter your number");
        int number = enter.nextInt();
        anotherApproach(number);
    }
}
