package Practice.InterviewQuestion.Random;

/*

Q.3

Write a program to print the following pattern

Input: 10
Output:
1 2 7
2 7 1
7 1 2

Let's take row one -> 1 + 2 + 7 = 10
Let's take last column -> 7 + 1 + 2 = 10

Note: Output should be always be a 3*3 matrix pattern
Also sum of values of any row or any column should match the provided input


*/

import java.util.Random;
import java.util.Scanner;

public class MatrixQuestion{
    //done. upper bound used carefully
    //removed used of switch case
    //the allocation of element into the indexes are dynamic now.
    public static void matrix(int matchElement){
        Random random = new Random();
        boolean found = false;
        int first,second,third;
        if(matchElement>24 || matchElement<3){
            System.out.println("some of unique element greater than 21 or less than 3 is not possible!!!");
        }else {
            do {
                first = random.nextInt(0, 10);
                second = random.nextInt(0, 10);
                third = random.nextInt(0, 10);
                if (first != second && second != third &&
                        third != first && (first + second + third) == matchElement) {
                    found = true;
                }
            } while (!found);



            int[][] ourMatrix = new int[3][3];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if(col==0){
                        ourMatrix[row][col] = first;
                    }else if(col==1){
                        ourMatrix[row][col] = second;
                    }else {
                        ourMatrix[row][col] = third;
                    }
                }
                int temp = first;
                first = second;
                second = third;
                third = temp;
            }
            for (int[] read : ourMatrix) {
                for (int box : read) {
                    System.out.print(box + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        matrix(24);
    }
}
