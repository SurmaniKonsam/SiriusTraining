package Practice.InterviewQuestion.Random;

import java.util.Scanner;


//try to minimize the obsolete gap.

public class PrimeNumberWithinRange {
    /**
     *
     * @param starting :
     * @param end :
     */
    public static void primeNumber(int starting, int end){
        for(;starting<end;starting++){
            if(primeNumberTest(starting)){
                System.out.print(starting+" ");
            }
        }
    }

    /**
     *
     * @param number
     * @return
     * how we can extract java docs?
     * how we can see java docs in web-browser?
     */
    public static boolean primeNumberTest(int number){
        if(number == 1){
            return false;
        }
        for(int i = 2;i<=number/2;i++){//eg:: 8  -> 2,3,4
            if(number%i==0){
                return false;
            }
        }
        return true;//will return true if the number is prime....
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner enterNumber = new Scanner(System.in);
        System.out.println("Enter starting number!!!");
        int starting = enterNumber.nextInt();
        System.out.println("Enter ending number!!!");
        int ending = enterNumber.nextInt();
        primeNumber(starting,ending);
    }
}
