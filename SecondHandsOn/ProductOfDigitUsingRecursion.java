package Practice.InterviewQuestion.Random;

/*

Q.5

Find the final product of the given number till it reaches one digit
Input: 347
Output: 6

347 -> 3*4*7 = 84 -> 8*4 -> 32 -> 3*2 -> 6
Stop the program when it becomes single digit product
Note: Use Recursion to solve this problem

*/

public class ProductOfDigitUsingRecursion {

    //this will give me the product of digits.
    public static int productOfDigits(int number){
        if(number<10){
            return number;
        }else
            return number%10 * productOfDigits(number/10);
    }

    //this will check if the argument is single digit or not.
    public static int checkIfDigitIsSingleOrNot(int number){
        if(number/10==0){
            return number;
        }
        return checkIfDigitIsSingleOrNot(productOfDigits(number));
    }

    //using nachi's method
    public static int calculateProduct(int n)
    {
        if(n == 0){
            return 1 ;
        }
        return (n%10) * calculateProduct(n/10) ;
    }




    public static void main(String[] args) {
        System.out.println(checkIfDigitIsSingleOrNot(347));
        System.out.println(calculateProduct(347));

    }

}
