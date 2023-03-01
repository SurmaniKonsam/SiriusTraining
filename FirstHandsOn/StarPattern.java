package Practice.InterviewQuestion.Random;

import java.util.Scanner;

public class StarPattern {
    public static void enterInput(int row){
            int firstLimit = row + 1;
            int secondLimit = row - 1;
            int column = (int)(row + 2 * Math.floor((double)row / 2));
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    if (j >= firstLimit - i && j <= secondLimit + i) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
    }

    //Method (2) being mindful about the spaces after the stars,
    //obliterating the need of iteration for the spaces after the star patterns
    public static void anotherMethodToStarPattern(int row){
        int column = (int)(row + 2 * Math.floor((double)row / 2));
        for(int i = 1;i<=row;i++){
            for(int j = 1;j<=column;j++){
                //for spaces.
                if(j>=1 && j<=row-i){
                    System.out.print(" ");
                }
                //for star
                else if(j>=((2*(row/2 + 1))-i) && j<=((2*(row/2))+i)){
                    System.out.print("*");
                }
            }System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.println("Enter your row value!!!");
        int row = enter.nextInt();
        enterInput(row);
        System.out.println();
        anotherMethodToStarPattern(row);
    }
}//end of class
