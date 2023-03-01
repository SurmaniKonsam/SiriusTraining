package Practice.InterviewQuestion.Random.ReadingAndWritting;


import java.io.*;

public class FirstFileHandling extends ThirdHandsOn{


    public static void main(String[] args) throws IOException {
        //case -1 and case -2  complete.
        System.out.println("Case-1 and Case-2: Display all the Regions and periods per as a List without Duplicates");
        System.out.println("----------------------------------------------------------------------------------------");
        int i = 1;
        while(i<=2){
            getUniqueRegionAndPeriod(i);
            i++;
        }
        System.out.println();

        //case - 3 overallBirths for all years
        System.out.println("Case-3: Find the overall Birth and Death count for all the years ");
        System.out.println("----------------------------------------------------------------");
        int j = 1;
        while(j<=2){
            overallBirthsAndDeaths(j);
            j++;
        }

//        overallDeaths();
        System.out.println();

//        case -  4 yearBirth and death.
        System.out.println("Case-4:  Calculate the Year wise Birth and Death Ex: 2005 -> No of Birth, No of Death");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("total Number of births mapped with year : "+totalNumberOfBirthsDeathsPerYear(1));
        System.out.println("total Number of Deaths mapped with year : "+totalNumberOfBirthsDeathsPerYear(2));

        System.out.println();

        try{
            System.out.println("Case-5: Display the number of Birth and Death for all the years for a specific Region ");
            System.out.println("-------------------------------------------------------------------------------------");
            numberOfBirthAndDeathForAllTheYearForASpecificRegion();
            System.out.println();
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }


        System.out.println();
        System.out.println("Case-6: Which year has highest birth and death rate another method!!!");
        System.out.println("---------------------------------------------------------------------");
        int deathBirth = 1;
        while(deathBirth<=2){
            maximumDeathAndBirthYear(deathBirth);
            deathBirth++;
        }
        System.out.println();
        System.out.println();

        try{
            System.out.println("Case-7: Display the highest Birth and Death Rate for each region along with the year");
            System.out.println("------------------------------------------------------------------------------------");
            highestBirthRateAndDeathRateForEachRegionAlongWithTheYear();
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
