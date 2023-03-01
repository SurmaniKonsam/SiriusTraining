package Practice.InterviewQuestion.Random.ReadingAndWritting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ThirdHandsOn {
    //create a standalone method for reading.
    //need to remove redundant code.

    //standalone method for reading.
    public static BufferedReader readLines() throws FileNotFoundException {
        String path = "C:\\Users\\Surmani Konsam\\Desktop\\Copy of Birth And Death Dataset in .csv";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bufferedReader;
    }

    //this is needed for a specific method to remove the redundancy of the code.
    public static int getStartingYear() throws IOException {
        String path = "C:\\Users\\Surmani Konsam\\Desktop\\Copy of Birth And Death Dataset in .csv";
        FileReader fileReader = new FileReader(path);
        BufferedReader getStartingYear = new BufferedReader(fileReader);
        getStartingYear.readLine();
        return Integer.parseInt(getStartingYear.readLine().split(",")[0]);
    }



    public static int getEndingYear() {
        BufferedReader bufferedReader = null;
        int endingYear = 0;
        try {
            bufferedReader = readLines();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] intoArray = line.split(",");
                endingYear = Integer.parseInt(intoArray[0]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return endingYear;
    }


    public static void getUniqueRegionAndPeriod(int region) {
        Set<String> uniqueRegionAndPeriod = new TreeSet<>();
        BufferedReader bufferedReader = null;
        String line;
        switch (region){
            case 1 -> {
                try {
                    bufferedReader = readLines();
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] intoArray = line.split(",");
                        uniqueRegionAndPeriod.add(intoArray[2]);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    try {
                        assert bufferedReader != null;
                        bufferedReader.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("unique Regions : "+uniqueRegionAndPeriod);
            }

            case 2 -> {
                try {
                    bufferedReader = readLines();
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] intoArray = line.split(",");

                        uniqueRegionAndPeriod.add(intoArray[0]);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    try {
                        assert bufferedReader != null;
                        bufferedReader.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("unique period : "+uniqueRegionAndPeriod);
            }
        }
    }




    //overall birth and death can be clubbed together.
    public static void overallBirthsAndDeaths(int birthOrDeath) {
        try (BufferedReader bufferedReader = readLines()) {
            String line;
            int startingPeriod = getStartingYear();
            double averageCount = 0;
            double births = 0;
            double overallBirths;
            int deathCounts = 0;
            double deaths = 0;
            double overallDeaths;
            HashMap<Integer, Double> overallBirthsAndDeathMappedWithYear = new HashMap<>();
//            bufferedReader.readLine();
            switch (birthOrDeath) {
                case 1 -> {
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] intoArray = line.split(",");
                        if (startingPeriod == Integer.parseInt(intoArray[0]) && Objects.equals(intoArray[1], "Births")) {
                            averageCount++;
                            births = births + Double.parseDouble(intoArray[3]);
                        }
                        //what if the deaths is not included in the next different year.
                        //intoArray[0] must be made equal to starting period in the second else if because
                        //it needs to go inside the second iteration for the death for the same year, and increment
                        //or change its year having done, that in the second iteration, when it will again check the
                        //else if, since the startingPeriod is already incremented we can see that it won't go inside
                        //the else if and hence our code will be successfully executed.
                        else if (!Objects.equals(intoArray[1], "Births") && Integer.parseInt(intoArray[0]) == startingPeriod) {
                            overallBirths = births / averageCount;
                            //finding average of all the births per year, and then persisting it inside
                            //the hashMap we have created where the key shall be the year.
                            overallBirthsAndDeathMappedWithYear.put(startingPeriod, (double) Math.round(overallBirths));
                            startingPeriod++;
                            averageCount = 0;
                            births = 0;
                        }
                    }
                    System.out.println("overall births : " + overallBirthsAndDeathMappedWithYear);
                }
                case 2 -> {
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] intoArray = line.split(",");
                        if (Integer.parseInt(intoArray[0]) == startingPeriod && Objects.equals(intoArray[1], "Deaths")) {
                            deathCounts++;
                            deaths = deaths + Double.parseDouble(intoArray[3]);
                        } else if (Integer.parseInt(intoArray[0]) != startingPeriod) {
                            overallDeaths = deaths / deathCounts;
                            overallBirthsAndDeathMappedWithYear.put(startingPeriod, (double) Math.round(overallDeaths));
                            deathCounts = 0;
                            deaths = 0;
                            startingPeriod++;
                        } else if (startingPeriod == getEndingYear() && Objects.equals(intoArray[1], "Deaths")) {
                            deathCounts++;
                            deaths = deaths + Double.parseDouble(intoArray[3]);
                        }
                        overallBirthsAndDeathMappedWithYear.put(startingPeriod, (double) Math.round(deaths / deathCounts));
                    }

                    System.out.println("overall deaths : " + overallBirthsAndDeathMappedWithYear);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //4-th case.
//    public static HashMap<Integer, Integer> totalNumberOfBirthsPerYear() throws IOException {
//        BufferedReader bufferedReader = readLines();
//        int startingYear = getStartingYear();
//        int totalNumberOfBirths = 0;
//
//        HashMap<Integer, Integer> totalNumberOfBirthsPerYear = new HashMap<>();
//
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] intoArray = line.split(",");
//            if (startingYear == Integer.parseInt(intoArray[0]) && Objects.equals(intoArray[1], "Births")) {
//                totalNumberOfBirths = totalNumberOfBirths + Integer.parseInt(intoArray[3]);
//            }
//            if (startingYear != Integer.parseInt(intoArray[0])) {
//                totalNumberOfBirthsPerYear.put(startingYear, totalNumberOfBirths);
//                startingYear++;
//                totalNumberOfBirths = 0;
//            }
//            if (startingYear == getEndingYear()) {
//                if (Objects.equals(intoArray[1], "Births")) {
//                    totalNumberOfBirths = totalNumberOfBirths + Integer.parseInt(intoArray[3]);
//                }
//            }
//            totalNumberOfBirthsPerYear.put(startingYear, totalNumberOfBirths);
//        }
//        return totalNumberOfBirthsPerYear;
//    }


    //creating a common block of code for both
    public static HashMap<Integer, Integer> totalNumberOfBirthsDeathsPerYear(int birthOrDeath) throws IOException {
        BufferedReader bufferedReader = readLines();
        int startingYear = getStartingYear();
        int totalNumberOfBirths = 0;

        HashMap<Integer, Integer> totalNumberOfBirthsDeathsPerYear = new HashMap<>();

        String line;
        switch (birthOrDeath){
            case 1 -> {
//                System.out.println("birth count mapped");
                while ((line = bufferedReader.readLine()) != null) {
                    String[] intoArray = line.split(",");
                    if (startingYear == Integer.parseInt(intoArray[0]) && Objects.equals(intoArray[1], "Births")) {
                        totalNumberOfBirths = totalNumberOfBirths + Integer.parseInt(intoArray[3]);
                    }
                    if (startingYear != Integer.parseInt(intoArray[0])) {
                        totalNumberOfBirthsDeathsPerYear.put(startingYear, totalNumberOfBirths);
                        startingYear++;
                        totalNumberOfBirths = 0;
                    }
                    if (startingYear == getEndingYear()) {
                        if (Objects.equals(intoArray[1], "Births")) {
                            totalNumberOfBirths = totalNumberOfBirths + Integer.parseInt(intoArray[3]);
                        }
                    }
                    totalNumberOfBirthsDeathsPerYear.put(startingYear, totalNumberOfBirths);
                }
            }
            case 2 -> {
                int totalDeaths = 0;
//                System.out.println("death count mapped");
                while ((line = bufferedReader.readLine()) != null) {
                    String[] intoArray = line.split(",");
                    //sum of all deaths happening in a specific year.
                    if (Integer.parseInt(intoArray[0]) == startingYear && Objects.equals(intoArray[1], "Deaths")) {
                        totalDeaths = totalDeaths + Integer.parseInt(intoArray[3]);
                    }
                    //once, the same year changes we will map the sum deaths to the hashmap with the respective year
                    //to which it was calculated.
                    else if (Integer.parseInt(intoArray[0]) != startingYear) {
                        totalNumberOfBirthsDeathsPerYear.put(startingYear, totalDeaths);
                        totalDeaths = 0;
                        startingYear++;
                        //and this will keep getting incremented for the reason when it will reach the ending year
                        //we will get our total death counts and then return the map of all the sum of the deaths
                        //mapped with the year.
                    }
                    else if (startingYear == getEndingYear() && Objects.equals(intoArray[1], "Deaths")) {
                        totalDeaths = totalDeaths + Integer.parseInt(intoArray[3]);
                    }

                    totalNumberOfBirthsDeathsPerYear.put(startingYear, totalDeaths);
                }
            }
        }
        return totalNumberOfBirthsDeathsPerYear;
    }

    public static void maximumDeathAndBirthYear(int birthDeathCount) throws IOException {
        int maxDeathYear = 0;
        int maxBirthYear = 0;
        int maxDeath = 0;
        int maxBirth = 0;
        //2005 - 12
        //2006 - 12
        switch (birthDeathCount){
            case 1 -> {
                for (Map.Entry<Integer, Integer> entry : totalNumberOfBirthsDeathsPerYear(1).entrySet()) {
                    if (maxBirth <= entry.getValue()) {
                        maxBirth = entry.getValue();
                    }
                }

                for (Map.Entry<Integer, Integer> entry : totalNumberOfBirthsDeathsPerYear(1).entrySet()) {
                    if (maxBirth == entry.getValue()) {
                        maxBirthYear = entry.getKey();
                    }
                }
                System.out.println("Max birth year : " +maxBirthYear+" total number of birth count in the year : " +
                        ""+maxBirthYear+" : "+maxBirth);
            }


            case 2 -> {
                for (Map.Entry<Integer, Integer> entry : totalNumberOfBirthsDeathsPerYear(2).entrySet()) {
                    if (maxDeath <= entry.getValue()) {
                        maxDeath = entry.getValue();
                    }
                }

                for (Map.Entry<Integer, Integer> entry : totalNumberOfBirthsDeathsPerYear(2).entrySet()) {
                    if (maxDeath == entry.getValue()) {
                        maxDeathYear = entry.getKey();
                    }
                }

                System.out.println("Max death year : " +maxDeathYear+" total number of death count in the year : "+maxDeathYear+"" +
                        " : "+maxDeath);
            }
        }



    }




    //4-th case total number of deaths mapped with year
//    public static HashMap<Integer, Integer> totalNumberOfDeathPerYear() throws IOException {
//        BufferedReader bufferedReader = readLines();
//        int startingYear = getStartingYear();
//
//        HashMap<Integer, Integer> totalNumberOfDeathsMappedWithYear = new HashMap<>();
//        String line;
//
//        int totalDeaths = 0;
//        try{
////            bufferedReader.readLine();
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] intoArray = line.split(",");
//                //sum of all deaths happening in a specific year.
//                if (Integer.parseInt(intoArray[0]) == startingYear && Objects.equals(intoArray[1], "Deaths")) {
//                    totalDeaths = totalDeaths + Integer.parseInt(intoArray[3]);
//                }
//                //once, the same year changes we will map the sum deaths to the hashmap with the respective year
//                //to which it was calculated.
//                else if (Integer.parseInt(intoArray[0]) != startingYear) {
//                    totalNumberOfDeathsMappedWithYear.put(startingYear, totalDeaths);
//                    totalDeaths = 0;
//                    startingYear++;
//                    //and this will keep getting incremented for the reason when it will reach the ending year
//                    //we will get our total death counts and then return the map of all the sum of the deaths
//                    //mapped with the year.
//                }
//                else if (startingYear == getEndingYear() && Objects.equals(intoArray[1], "Deaths")) {
//                    totalDeaths = totalDeaths + Integer.parseInt(intoArray[3]);
//                }
//
//                totalNumberOfDeathsMappedWithYear.put(startingYear, totalDeaths);
//            }
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }finally {
//            bufferedReader.close();
//        }
//
//
//        return totalNumberOfDeathsMappedWithYear;
//    }



    //4-th case
//    public static void maxDeathAndBirthYear() throws IOException {
//        int maxDeathYear = 0;
//        int maxBirthYear = 0;
//        int maxDeath = 0;
//        int maxBirth = 0;
//        //2005 - 12
//        //2006 - 12
//        for (Map.Entry<Integer, Integer> entry : totalNumberOfBirthsPerYear().entrySet()) {
//            if (maxBirth <= entry.getValue()) {
//                maxBirth = entry.getValue();
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entry : totalNumberOfBirthsPerYear().entrySet()) {
//            if (maxBirth == entry.getValue()) {
//                maxBirthYear = entry.getKey();
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entry : totalNumberOfDeathPerYear().entrySet()) {
//            if (maxDeath <= entry.getValue()) {
//                maxDeath = entry.getValue();
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entry : totalNumberOfDeathPerYear().entrySet()) {
//            if (maxDeath == entry.getValue()) {
//                maxDeathYear = entry.getKey();
//            }
//        }
//        System.out.println("Max birth year : " +maxBirthYear+" total number of birth count in the year : " +
//                ""+maxBirthYear+" : "+maxBirth);
//        System.out.println("Max death year : " +maxDeathYear+" total number of death count in the year : "+maxDeathYear+"" +
//                " : "+maxDeath);
//    }


    public static void numberOfBirthAndDeathForAllTheYearForASpecificRegion() throws IOException {
//        String path = "C:\\Users\\Surmani Konsam\\Desktop\\Copy of Birth And Death Dataset in .csv";
//        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = readLines();
        String line;
//        String[] numberOfBirthAndDeath = new String[getLengthOfTheFile()-1];
        List<String> numberOfBirthAndDeathHappened = new ArrayList<>();
//        int i = 0;
        try {
//            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
//                numberOfBirthAndDeath[i] = line;
                numberOfBirthAndDeathHappened.add(line);
//                i++;
            }
        }catch (IOException | NullPointerException e){
            System.out.println(e.getMessage());
        }finally {
            bufferedReader.close();
        }


        //mimicking concept of multidimensional array.
        for(int innerRow = 0;innerRow<numberOfBirthAndDeathHappened.size()-1;innerRow++){
            String[] intoArray = numberOfBirthAndDeathHappened.get(innerRow).split(",");
            for(int outerRow = innerRow+1;outerRow<numberOfBirthAndDeathHappened.size();outerRow++){
                String[] innerArray = numberOfBirthAndDeathHappened.get(outerRow).split(",");
                if(Objects.equals(intoArray[2], innerArray[2]) && Objects.equals(innerArray[0], intoArray[0])){
                    System.out.println("year : "+intoArray[0]+", region : "+intoArray[2]+", birth Count : "+intoArray[3]+"" +
                            ", death count : "+innerArray[3]);
                    break;
                }
            }
        }
    }



    public static void highestBirthRateAndDeathRateForEachRegionAlongWithTheYear() throws IOException {
        BufferedReader bufferedReader = readLines();
        String line;

        //String[] numberOfBirthAndDeath = new String[getLengthOfTheFile()-1];

        List<String> maxBirthsAndDeaths = new ArrayList<>();

        try{
//            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                //numberOfBirthAndDeath[i] = line;
                maxBirthsAndDeaths.add(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            bufferedReader.close();
        }



        //this will be used as length for the array of maximumBirthAndDeathMappedWithYearWiseRegion.
//        int indexForMaximumBirthAndDeath = 0;
//        for(int innerRow = 0;innerRow<numberOfBirthAndDeath.length-1;innerRow++){
//            String[] intoArray = numberOfBirthAndDeath[innerRow].split(",");
//            for(int outerRow = innerRow+1;outerRow<numberOfBirthAndDeath.length;outerRow++){
//                String[] innerArray = numberOfBirthAndDeath[outerRow].split(",");
//                if(Objects.equals(intoArray[2], innerArray[2]) && Objects.equals(innerArray[0], intoArray[0])){
//                    indexForMaximumBirthAndDeath++;
//                    break;
//                }
//            }
//        }
        //System.out.println("what the hell is this : "+indexForMaximumBirthAndDeath);
        //System.out.println("This will the give me the max size of regionWithDeathAndBirths");
        //System.out.println("_______________________________________________________");

        List<String> maxBirthDeathWithRegion = new ArrayList<>();

        for(int innerRow = 0;innerRow<maxBirthsAndDeaths.size()-1;innerRow++){
            String[] intoArray = maxBirthsAndDeaths.get(innerRow).split(",");
            for(int outerRow = innerRow+1;outerRow<maxBirthsAndDeaths.size();outerRow++){
                String[] innerArray = maxBirthsAndDeaths.get(outerRow).split(",");
                if(Objects.equals(innerArray[2], intoArray[2]) && Objects.equals(innerArray[0], intoArray[0])){
                    maxBirthDeathWithRegion.add(intoArray[0]+","+
                            intoArray[2]+","+intoArray[3]+","+innerArray[3]);
                    break;
                }
            }
        }

        //System.out.println("maxBirthDeathWithRegion : "+maxBirthDeathWithRegion);


        int maxBirthCount;
        int maxDeathCount;
        int maxYearWhichHappened = 0;
        for(int outerRow = 0;outerRow<maxBirthDeathWithRegion.size()-1;outerRow++){
            String[] intoArray = maxBirthDeathWithRegion.get(outerRow).split(",");
            maxBirthCount = Integer.parseInt(intoArray[2]);
            maxDeathCount = Integer.parseInt(intoArray[3]);
            String regionToCompareWith = intoArray[1];

            for(int innerRow = outerRow;innerRow<maxBirthDeathWithRegion.size();innerRow++){
                String[] innerRowArray = maxBirthDeathWithRegion.get(innerRow).split(",");
                if(Objects.equals(innerRowArray[1], regionToCompareWith) &&
                    Integer.parseInt(innerRowArray[2])>maxBirthCount &&
                    Integer.parseInt(innerRowArray[3])>maxDeathCount){

                    //with the last iteration we will have out max-birth/max-death
                    maxBirthCount = Integer.parseInt(innerRowArray[2]);
                    maxDeathCount = Integer.parseInt(innerRowArray[3]);
                    maxYearWhichHappened = Integer.parseInt(innerRowArray[0]);
                }
            }
            System.out.println("region : "+regionToCompareWith+" year : "+maxYearWhichHappened+" " +
                    "max-Birth : "+maxBirthCount+" max-Death : "+maxDeathCount);
            if(outerRow==17){
                break;
            }
        }




//        String[] maximumBirthAndDeathMappedWithYearWiseRegion = new String[indexForMaximumBirthAndDeath];
//        int indexForMaxBirthAndDeath = 0; //and this is used for the index filled with value.
//        for(int innerRow = 0;innerRow<numberOfBirthAndDeath.length-1;innerRow++){
//            String[] intoArray = numberOfBirthAndDeath[innerRow].split(",");
//            for(int outerRow = innerRow+1;outerRow<numberOfBirthAndDeath.length;outerRow++){
//                String[] innerArray = numberOfBirthAndDeath[outerRow].split(",");
//                if(Objects.equals(intoArray[2], innerArray[2]) && Objects.equals(innerArray[0], intoArray[0])){
//                    indexForMaximumBirthAndDeath++;
//                    maximumBirthAndDeathMappedWithYearWiseRegion[indexForMaxBirthAndDeath] =  intoArray[0]+","+
//                            intoArray[2]+","+intoArray[3]+","+innerArray[3];
//                    //where intoArray[0] = year.
//                    //intoArray[1] = region name.
//                    //intoArray[2] = births.
//                    //intoArray[3] = deaths.
//                    indexForMaxBirthAndDeath++;
//                    break;
//                }
//            }
//        }

//        int countIterations = 1;
//        for(String read : maximumBirthAndDeathMappedWithYearWiseRegion){
//            System.out.println(read);
//            System.out.println(countIterations);
//            countIterations++;
//            System.out.println("----------------------------------------------------");
//        }

        //use collection here.
//
//        System.out.println();
//        System.out.println();
//        System.out.println();


//        int maxBirth;
//        int maxDeath;
//        int year = 0;
//        for(int outerMax = 0;outerMax<maximumBirthAndDeathMappedWithYearWiseRegion.length-1;outerMax++){
//            String[] outerMaxIntoArray = maximumBirthAndDeathMappedWithYearWiseRegion[outerMax].split(",");
//            maxBirth = Integer.parseInt(outerMaxIntoArray[2]);
//            maxDeath = Integer.parseInt(outerMaxIntoArray[3]);
//
//            //means it will first start its iteration from comparing with "northland region".
//            String regionToCompareWith = outerMaxIntoArray[1];
//
//            //and then it will check the regionToCompareWithTheRemainingInnerIteration.
//            for(int innerMax = outerMax;innerMax<maximumBirthAndDeathMappedWithYearWiseRegion.length;innerMax++)
//            {
//                String[] intoArray = maximumBirthAndDeathMappedWithYearWiseRegion[innerMax].split(",");
//                if(Objects.equals(intoArray[1], regionToCompareWith)
//                && Integer.parseInt(intoArray[2])>maxBirth
//                && Integer.parseInt(intoArray[3])>maxDeath){
//                    //now it shall do the iteration only for if the inner iteration intoArray[1] is equal to the
//                    //regionToCompareWith, and then the remaining data for which regionToCompareWith is there,
//                    //its birth that is the intoArray[2] shall be compared with our maxBirth,
//                    //same will happen with maxDeath,
//                    //and after all the inner loop iteration we will then have our maxBirth, maxDeath,with year it happened,
//                    maxBirth = Integer.parseInt(intoArray[2]);
//                    maxDeath = Integer.parseInt(intoArray[3]);
//                    year = Integer.parseInt(intoArray[0]);
//                }
//            }
//            System.out.println("region : "+regionToCompareWith+", max-Birth : "+maxBirth+"," +
//                    " max-Death : "+maxDeath+", year : "+year);
//            if(outerMax==17){
//                break;
//            }
//        }

    }
}
