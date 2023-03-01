//package Practice.InterviewQuestion.Random.AtmProject;
//
//import java.io.*;
//
//import java.util.Scanner;
//
//public class LevelThree extends Operations{
//    static Scanner enter = new Scanner(System.in).useDelimiter("\n");
//    OperationsForLevelThree operationsForLevelThree;
//
//    /**
//     *
//     * @param operationsForLevelThree used composition here.
//     */
//    LevelThree(OperationsForLevelThree operationsForLevelThree){
//        this.operationsForLevelThree = operationsForLevelThree;
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        LevelThree levelThree = new LevelThree(new OperationsForLevelThree());
//        System.out.println("Select the User-type!!!");
//        System.out.print("1.\tBank Administrator.\n2.\tCustomer\n");
//        int userType = enter.nextInt();
//        switch (userType){
//            case 1 -> {
//                System.out.println("Hello Bank Administrator!!!");
//                System.out.print("Kindly please select the banks given below for your administration!!!\n");
//                System.out.print("1.\tbank_ABC.\n2.\tbank_DEF.\n3.\tbank_XYZ.\n");
//                int bankChoices = enter.nextInt();
//                levelThree.operationsForLevelThree.bankChoices(bankChoices,true);
//            }
//            case 2 -> {
//                System.out.println("Hello Customer!!!. Here are the list of banks" +
//                        " with which you can open your account with, please choose one of them!!!");
//                System.out.print("1.\tbank_ABC.\n2.\tbank_DEF.\n3.\tbank_XYZ.\n");
//                int bankChoices = enter.nextInt();
//                levelThree.operationsForLevelThree.bankChoices(bankChoices,false);
//            }
//            default -> System.out.println("No such user-type available!!!");
//        }
//    }
//
//    //need to give a user-id and a password to login.
//
//}
