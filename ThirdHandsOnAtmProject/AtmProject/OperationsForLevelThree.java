//package Practice.InterviewQuestion.Random.AtmProject;
//
//import java.io.*;
//import java.util.*;
//
//public class OperationsForLevelThree extends Operations implements LevelThreeOperations {
//    static Scanner enter = new Scanner(System.in);
//    static File fileLocation = new File("InterviewQuestion/Random/AtmProject");
//    static File bank_ABC = new File(fileLocation,"Bank_ABC.csv");
//    static File bank_DEF = new File(fileLocation,"Bank_DEF.csv");
//    static File bank_XYZ = new File(fileLocation,"Bank_XYZ.csv");
//    static File ABCBlockCard = new File(fileLocation,"ABCBlockedCards.csv");
//    static File DEFBlockedCards = new File(fileLocation,"DEFBlockedCards.csv");
//    static File XYZBlockedCards = new File(fileLocation,"XYZBlockedCards.csv");
//
//    @Override
//    public void bankChoices(int choices,boolean typeOfUser) throws IOException {
//        String bankName;
//        switch (choices){
//            case 1 -> {
//                bankName = "bank_ABC";
//                int operations;
//                if(typeOfUser){
//                    System.out.println("Welcome to bank_ABC administrator");
//                    super.administratorOperations();
//                    operations = enter.nextInt();
//                    this.administratorOperations(operations,bankName);
//                }else {
//                    super.customerOperations();
//                    operations = enter.nextInt();
//                    this.bankOperations(operations, bankName);
//                }
//            }
//            case 2 -> {
//                bankName = "bank_DEF";
//                int operations;
//                if(typeOfUser) {
//                    System.out.println("Welcome to bank_DEF administrator");
//                    super.administratorOperations();
//                    operations =  enter.nextInt();
//                    this.administratorOperations(operations,bankName);
//                }else {
//                    super.customerOperations();
//                    operations = enter.nextInt();
//                    this.bankOperations(operations,bankName);
//                }
//            }
//            case 3 -> {
//                bankName = "bank_XYZ";
//                int operations;
//                if(typeOfUser){
//                    System.out.println("Welcome to bank_XYZ administrator");
//                    super.administratorOperations();
//                    operations = enter.nextInt();
//                    this.administratorOperations(operations,bankName);
//                }else{
//                    super.customerOperations();
//                    operations = enter.nextInt();
//                    this.bankOperations(operations,bankName);
//                }
//            }
//            default -> System.out.println("Sorry customer we don't have such bank!!!");
//        }
//    }
//
//    public void administratorOperations(int Operations,String bankName) throws IOException {
//        switch (Operations){
//            case 1 -> {
//                System.out.println("View all customer data!!!");
//                this.readCardUser(bankName);
//            }
//            case 2 -> {
//                System.out.println("view all issued cards!!!");
//                System.out.println("Please enter the userName administrator");
//                String name = enter.next();
//                this.issuedCards(bankName,name);
//            }
//            case 3,4 -> {
//                System.out.println("Add new customers!!!");
//                this.availableCards(bankName);
//            }
//            case 5 -> {
//                System.out.println("View block cards");
//                this.viewBlockCardsLevelThree(bankName);
//
//            }
//        }
//    }
//
//    public void viewBlockCardsLevelThree(String bankName) throws IOException {
//        switch (bankName){
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(ABCBlockCard);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                while ((line = bufferedReader.readLine()) != null) {
//                    System.out.println(line);
//                }
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(DEFBlockedCards);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                while((line = bufferedReader.readLine())!=null){
//                    System.out.println(line);
//                }
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(XYZBlockedCards);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                while((line = bufferedReader.readLine())!=null){
//                    System.out.println(line);
//                }
//            }
//        }
//    }
//
//    public void bankOperations(int operations,String bankName) throws IOException {
//        switch (operations){
//            case 1 -> {
//                System.out.println("Applying for a new card");
//                this.availableCards(bankName);
//            }
//            case 2 -> {
//                System.out.println("Please Enter Your name");
//                String name = enter.next();
//                if(this.whetherUserNameExistOrNot(name,bankName)){
//                    this.viewBalance(bankName,name);
//                }else{
//                    System.out.println(name+" user doesn't exist with bank "+bankName);
//                }
//
//            }
//            case 3 -> {
//                System.out.println("close/block debit card");
//                System.out.println("Please Enter Your name");
//                String name = enter.next();
//                if(this.whetherUserNameExistOrNot(name,bankName)){
//                    this.closeBlockCards(bankName,name);
//                }else{
//                    System.out.println(name+" user doesn't exist with bank "+bankName);
//                }
//            }
//            case 4 -> {
//                System.out.println("Buy items");
//                System.out.println("Please enter your name!!!");
//                String name = enter.next();
//                if(this.whetherUserNameExistOrNot(name,bankName)){
//                    this.purchaseItemsLevelThree(name,bankName);
//                }else{
//                    System.out.println(name+" user doesn't exist with "+bankName);
//                }
//            }
//            case 5 -> {
//                System.out.println("View all customers data");
//                System.out.println("-----------------------");
//                this.readCardUser(bankName);
//            }
//            case 6 -> this.logOutUser(bankName);
//            default -> System.out.println("No such operations available");
//        }
//    }
//
//    public boolean whetherUserNameExistOrNot(String userName, String bankName) throws IOException {
//        boolean flag = false;
//        switch (bankName) {
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while ((line = bufferedReader.readLine()) != null) {
//                    intoArray = line.split(",");
//                    if (Objects.equals(intoArray[0], userName)) {
//                        flag = true;
//                        break;
//                    }
//                }
//                bufferedReader.close();
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while ((line = bufferedReader.readLine()) != null) {
//                    intoArray = line.split(",");
//                    if (Objects.equals(intoArray[0], userName)) {
//                        flag = true;
//                        break;
//                    }
//                }
//                bufferedReader.close();
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while ((line = bufferedReader.readLine()) != null) {
//                    intoArray = line.split(",");
//                    if (Objects.equals(intoArray[0], userName)) {
//                        flag = true;
//                        break;
//                    }
//                }
//                bufferedReader.close();
//            }
//        }
//        return flag;
//    }
//
//    public void logOutUser(String bankName) throws IOException {
//        switch (bankName){
//            case "bank_ABC"->{
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                bufferedReader.readLine();
//                System.out.println("Enter your name please!!!");
//                String name = enter.next();
//                String line;
//                String[] intoArray;
//                boolean flag = false;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Objects.equals(intoArray[0], name)){
//                        System.out.println(intoArray[0]+" it was nice having you we'll meet again");
//                        flag = true;
//                        break;
//                    }
//                }
//                if(!flag){
//                    System.out.println("Sorry "+name+" you are not part of our BankXYZ!!!");
//                }
//                bufferedReader.close();
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                bufferedReader.readLine();
//                System.out.println("Enter your name please!!!");
//                String name = enter.next();
//                String line;
//                String[] intoArray;
//                boolean flag = false;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Objects.equals(intoArray[0], name)){
//                        System.out.println(intoArray[0]+" it was nice having you we'll meet again");
//                        flag = true;
//                        break;
//                    }
//                }
//                if(!flag){
//                    System.out.println("Sorry "+name+" you are not part of our BankXYZ!!!");
//                }
//                bufferedReader.close();
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                bufferedReader.readLine();
//                System.out.println("Enter your name please!!!");
//                String name = enter.next();
//                String line;
//                String[] intoArray;
//                boolean flag = false;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Objects.equals(intoArray[0], name)){
//                        System.out.println(intoArray[0]+" it was nice having you we'll meet again");
//                        flag = true;
//                        break;
//                    }
//                }
//                if(!flag){
//                    System.out.println("Sorry "+name+" you are not part of our BankXYZ!!!");
//                }
//                bufferedReader.close();
//            }
//        }
//    }
//
//    public void issuedCards(String bankName,String userName) throws IOException {
//        boolean readUserNameExist = false;
//        switch (bankName){
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Objects.equals(userName, intoArray[0])){
//                        System.out.println("Issued cards : "+intoArray[1]);
//                        readUserNameExist = true;
//                    }
//                }
//                if(!readUserNameExist){
//                    System.out.println("Sorry administrator no such user exist");
//                }
//                bufferedReader.close();
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Objects.equals(userName, intoArray[0])){
//                        System.out.println("Issued cards : "+intoArray[1]);
//                        readUserNameExist = true;
//                    }
//                }
//                if(!readUserNameExist){
//                    System.out.println("Sorry administrator no such user exist");
//                }
//                bufferedReader.close();
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Objects.equals(userName, intoArray[0])){
//                        System.out.println("Issued cards : "+intoArray[1]);
//                        readUserNameExist = true;
//                    }
//                }
//                if(!readUserNameExist){
//                    System.out.println("Sorry administrator no such user exist");
//                }
//                bufferedReader.close();
//            }
//        }
//    }
//
//    public void readCardUser(String bankName) throws IOException {
//        switch (bankName){
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                while((line=bufferedReader.readLine())!=null){
//                    System.out.println(line);
//                }
//                bufferedReader.close();
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                while((line=bufferedReader.readLine())!=null){
//                    System.out.println(line);
//                }
//                bufferedReader.close();
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                while((line=bufferedReader.readLine())!=null){
//                    System.out.println(line);
//                }
//                bufferedReader.close();
//            }
//        }
//    }
//
//    public void viewBalance(String bankName,String userName) throws IOException {
//        switch (bankName){
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                int countSerialNo = 0;
//                int choices;
//                long creditCardNumber;
//                String[] intoArray;
//                System.out.println("Select your available card to view balance");
//                HashMap<Integer, Integer> balanceMappedWithSerialNo = new HashMap<>();
//                HashMap<Integer,Long> cardNumberMappedToSerialNo = new HashMap<>();
//                while ((line = bufferedReader.readLine()) != null) {
//                    intoArray = line.split(",");
//                    if (Objects.equals(intoArray[0], userName)) {
//                        countSerialNo++;
//                        balanceMappedWithSerialNo.put(countSerialNo, Integer.parseInt(intoArray[3]));
//                        cardNumberMappedToSerialNo.put(countSerialNo,Long.parseLong(intoArray[1]));
//                        System.out.println(countSerialNo + ".\t" + intoArray[1]);
//                    }
//                }
//                choices = enter.nextInt();
//                for (Map.Entry<Integer, Integer> entry : balanceMappedWithSerialNo.entrySet()) {
//                    if (entry.getKey() == choices) {
//                        creditCardNumber = cardNumberMappedToSerialNo.get(choices);
//                        boolean rightPin = false;
//                        int pinAttempts = 0;
//                        int pin;
//                        int cardNumberPin = this.getCardPin(creditCardNumber,bankName);
//                        System.out.println("Your card is :: "+creditCardNumber);
//                        do{
//                            System.out.println("Please enter the 4 digit pin for the card thus chosen!!!");
//                            pin = enter.nextInt();
//                            pinAttempts++;
//                            if(this.countPinDigitCount(pin)){
//                                if(pin==cardNumberPin) {
//                                    System.out.println("You can spend up-to " + entry.getValue());
//                                    rightPin = true;
//                                }
//                            }
//                            if(pinAttempts==3 && !rightPin){
//                                System.out.println("You have exhausted your limit!!!");
//                                break;
//                            }
//                        }while(pin!=cardNumberPin);
//                    }
//                }
//                bufferedReader.close();
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                int countSerialNo = 0;
//                int choices;
//                long creditCardNumber;
//                String[] intoArray;
//                System.out.println("Select your available card to view balance");
//                HashMap<Integer, Integer> balanceMappedWithSerialNo = new HashMap<>();
//                HashMap<Integer,Long> cardNumberMappedToSerialNo = new HashMap<>();
//                while ((line = bufferedReader.readLine()) != null) {
//                    intoArray = line.split(",");
//                    if (Objects.equals(intoArray[0],userName)) {
//                        countSerialNo++;
//                        balanceMappedWithSerialNo.put(countSerialNo, Integer.parseInt(intoArray[3]));
//                        cardNumberMappedToSerialNo.put(countSerialNo,Long.parseLong(intoArray[1]));
//                        System.out.println(countSerialNo + ".\t" + intoArray[1]);
//                    }
//                }
//                choices = enter.nextInt();
//                for (Map.Entry<Integer, Integer> entry : balanceMappedWithSerialNo.entrySet()) {
//                    if (entry.getKey() == choices) {
//                        creditCardNumber = cardNumberMappedToSerialNo.get(choices);
//                        boolean rightPin = false;
//                        int pinAttempts = 0;
//                        int pin;
//                        int cardNumberPin = this.getCardPin(creditCardNumber,bankName);
//                        System.out.println("Your card is :: "+creditCardNumber);
//                        do{
//                            System.out.println("Please enter the 4 digit pin for the card thus chosen!!!");
//                            pin = enter.nextInt();
//                            pinAttempts++;
//                            if(this.countPinDigitCount(pin)){
//                                if(pin==cardNumberPin) {
//                                    System.out.println("You can spend up-to " + entry.getValue() + " this month!!!");
//                                    rightPin = true;
//                                }
//                            }
//                            if(pinAttempts==3 && !rightPin){
//                                System.out.println("You have exhausted your limit!!!");
//                                break;
//                            }
//                        }while(pin!=cardNumberPin);
//                    }
//                }
//                bufferedReader.close();
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                int countSerialNo = 0;
//                int choices;
//                long creditCardNumber;
//                String[] intoArray;
//                System.out.println("Select your available card to view balance");
//                HashMap<Integer, Integer> balanceMappedWithSerialNo = new HashMap<>();
//                HashMap<Integer,Long> cardNumberMappedToSerialNo = new HashMap<>();
//                while ((line = bufferedReader.readLine()) != null) {
//                    intoArray = line.split(",");
//                    if (Objects.equals(intoArray[0],userName)) {
//                        countSerialNo++;
//                        balanceMappedWithSerialNo.put(countSerialNo, Integer.parseInt(intoArray[3]));
//                        cardNumberMappedToSerialNo.put(countSerialNo,Long.parseLong(intoArray[1]));
//                        System.out.println(countSerialNo + ".\t" + intoArray[1]);
//                    }
//                }
//                choices = enter.nextInt();
//                for (Map.Entry<Integer, Integer> entry : balanceMappedWithSerialNo.entrySet()) {
//                    if (entry.getKey() == choices) {
//                        creditCardNumber = cardNumberMappedToSerialNo.get(choices);
//                        boolean rightPin = false;
//                        int pinAttempts = 0;
//                        int pin;
//                        int cardNumberPin = this.getCardPin(creditCardNumber,bankName);
//                        System.out.println("Your card is :: "+creditCardNumber);
//                        do{
//                            System.out.println("Please enter the 4 digit pin for the card thus chosen!!!");
//                            pin = enter.nextInt();
//                            pinAttempts++;
//                            if(this.countPinDigitCount(pin)){
//                                if(pin==cardNumberPin) {
//                                    System.out.println("You can spend up-to " + entry.getValue() + " this month!!!");
//                                    rightPin = true;
//                                }
//                            }
//                            if(pinAttempts==3 && !rightPin){
//                                System.out.println("You have exhausted your limit!!!");
//                                break;
//                            }
//                        }while(pin!=cardNumberPin);
//                    }
//                }
//                bufferedReader.close();
//            }
//        }
//    }
//
//
//
//    //To get card pin.
//    public int getCardPin(long cardNumber,String bankName) throws IOException {
//        int pin = 0;
//        switch (bankName) {
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while ((line = bufferedReader.readLine()) != null) {
//                    intoArray = line.split(",");
//                    if (cardNumber == Long.parseLong(intoArray[1])) {
//                        pin = Integer.parseInt(intoArray[2]);
//                    }
//                }
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while ((line = bufferedReader.readLine()) != null) {
//                    intoArray = line.split(",");
//                    if (cardNumber == Long.parseLong(intoArray[1])) {
//                        pin = Integer.parseInt(intoArray[2]);
//                    }
//                }
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while ((line = bufferedReader.readLine()) != null) {
//                    intoArray = line.split(",");
//                    if (cardNumber == Long.parseLong(intoArray[1])) {
//                        pin = Integer.parseInt(intoArray[2]);
//                    }
//                }
//            }
//            default -> System.out.println("sorry we have no such bank available with us!!!");
//        }
//        return pin;
//    }
//
//
//
//    @Override
//    public void availableCards(String bankName) throws IOException {
//        System.out.print("1.\tPlatinum.\n2.\tGold.\n3.\tDiamond.\n");
//        System.out.println("Enter your choice of cards which you want to apply for");
//        int choices = enter.nextInt();
//        switch (choices){
//            case 1 -> {
//                System.out.println("Thank you for applying for platinum card!!!");
//                System.out.println("You will be given a credit limit of 500000");
//                int depositOfFiveLac = 500000;
//                this.applyingCardForAllBanks(depositOfFiveLac,bankName);
//            }
//            case 2 -> {
//                System.out.println("Thank you for applying for Gold card.");
//                System.out.println("You will be given a credit limit of 1000000");
//                int depositOfTenLac = 1000000;
//                this.applyingCardForAllBanks(depositOfTenLac,bankName);
//
//            }
//            case 3 -> {
//                System.out.println("Thank you for applying for diamond card");
//                System.out.println("You will be given a credit limit of 1500000");
//                int depositOfFifteenLac = 1500000;
//                this.applyingCardForAllBanks(depositOfFifteenLac,bankName);
//            }
//            default -> System.out.println("Sorry we don't have such card with us!!!");
//        }
//    }
//
//
//    public void applyingCardForAllBanks(int deposit,String bankName) throws IOException {
//        switch (bankName){
//            case "bank_ABC" ->{
//                System.out.println("Welcome to bank_ABC");
//                this.applyCard(deposit,bankName);
//
//            }
//            case "bank_DEF" -> {
//                System.out.println("Welcome to bank_DEF");
//                this.applyCard(deposit,bankName);
//            }
//            case "bank_XYZ" -> {
//                System.out.println("Welcome to bank_XYZ");
//                this.applyCard(deposit,bankName);
//            }
//        }
//    }
//
//    //to apply for a credit-card
//    public void applyCard(int deposit,String bankName) throws IOException {
//        System.out.println("Applying for a new card");
//        System.out.println("Please enter your age!!!");
//        int age = enter.nextInt();
//        if (age <= 18) {
//            System.out.println("Sorry you are not eligible to create card");
//        }else{
//            System.out.println("Please enter your name!!!");
//            String name = enter.next();
//            super.setUserName(name);
//            System.out.println("Number of user with the same name " + super.getUserName() + " " +
//                    "is : " + this.countExistingUser(super.getUserName(),bankName));
//            int countExistingUser = this.countExistingUser(super.getUserName(),bankName);
//            if (countExistingUser >= 5) {
//                System.out.println("Sorry a single user can only have 5 credit card in its name");
//            }else{
//                long cardNumber;
//                int pinAttempts = 0;
//                boolean outOfLoop = false;
//                int cardAttempts = 0;
//                do{
//                    System.out.println("Please enter 12 digit card number");
//                    cardNumber = enter.nextLong();
//                    boolean rightPinAttempt = false;
//                    if(super.countCardNumberDigitsCount(cardNumber)) {
//                        if(this.checkIfCreditCardNumberAlreadyExistOrNot(bankName,cardNumber))
//                        {
//                            System.out.println("Card Number already exists try again");
//                        }
//
//                        if (!this.checkIfCreditCardNumberAlreadyExistOrNot(bankName, cardNumber)) {
//                            super.setCreditCardNumber(cardNumber);
//                            outOfLoop = true;
//                            int pin;
//                            do {
//                                System.out.println("Please enter 4 digit pins for your card");
//                                pin = enter.nextInt();
//                                pinAttempts++;
//                                if (super.countPinDigitCount(pin)) {
//                                    super.setCardPin(pin);
//                                    rightPinAttempt = true;
//                                    System.out.println("You have successfully created your pin");
//                                    System.out.println("An initial amount of " + deposit + " will be deposited in your card");
//                                    super.setDepositedAmount(deposit);
//                                    switch (bankName)
//                                    {
//                                        case "bank_ABC" -> {
//                                            FileWriter fileWriter = new FileWriter(bank_ABC, true);
//                                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                                            bufferedWriter.write(super.getUserName() + "," + super.getCreditCardNumber() + "," +
//                                                    "" + super.getCardPin() + "," + super.getDepositedAmount());
//                                            bufferedWriter.flush();
//                                            bufferedWriter.newLine();
//                                            bufferedWriter.close();
//                                            this.levelThreeReadCardUser(bankName);
//                                        }
//                                        case "bank_DEF" -> {
//                                            FileWriter fileWriter = new FileWriter(bank_DEF, true);
//                                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                                            bufferedWriter.write(super.getUserName() + "," + super.getCreditCardNumber() + "," +
//                                                    "" + super.getCardPin() + "," + super.getDepositedAmount());
//                                            bufferedWriter.flush();
//                                            bufferedWriter.newLine();
//                                            bufferedWriter.close();
//                                            this.levelThreeReadCardUser(bankName);
//                                        }
//                                        case "bank_XYZ" -> {
//                                            FileWriter fileWriter = new FileWriter(bank_XYZ, true);
//                                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                                            bufferedWriter.write(super.getUserName() + "," + super.getCreditCardNumber() + "," +
//                                                    "" + super.getCardPin() + "," + super.getDepositedAmount());
//                                            bufferedWriter.flush();
//                                            bufferedWriter.newLine();
//                                            bufferedWriter.close();
//                                            this.levelThreeReadCardUser(bankName);
//                                        }
//                                    }
//                                }
//                                if(pinAttempts==3 && !rightPinAttempt){
//                                    System.out.println("You have exhausted your limit");
//                                    break;
//                                }
//                            } while (!rightPinAttempt);
//                        }
//                    }
//                    cardAttempts++;
//                    if(cardAttempts>3 && !outOfLoop){
//                        System.out.println("You have exhausted your limit");
//                        break;
//                    }
//                }while(!outOfLoop);
//            }
//        }
//    }
//
//
//    //FOr Counting existing user.
//    public int countExistingUser(String name,String bankName) throws IOException {
//        int countUser = 0;
//        switch (bankName){
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Objects.equals(intoArray[0], name)){
//                        countUser++;
//                    }
//                }
//                bufferedReader.close();
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Objects.equals(intoArray[0], name)){
//                        countUser++;
//                    }
//                }
//                bufferedReader.close();
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Objects.equals(intoArray[0], name)){
//                        countUser++;
//                    }
//                }
//                bufferedReader.close();
//            }
//        }
//        return countUser;
//    }
//
//    //to check if the creditCard already exist in the .csv file or not.
//    public boolean checkIfCreditCardNumberAlreadyExistOrNot(String bankName,long cardNumber) throws IOException {
//        boolean caught = false;
//        switch (bankName){
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Long.parseLong(intoArray[1])==cardNumber){
//                        caught = true;
//                    }
//                }
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Long.parseLong(intoArray[1])==cardNumber){
//                        caught = true;
//                    }
//                }
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Long.parseLong(intoArray[1])==cardNumber){
//                        caught = true;
//                    }
//                }
//            }
//        }
//        return caught;
//    }
//
//
//    //used for reading card User
//    public void levelThreeReadCardUser(String bankName) throws IOException {
//        switch (bankName){
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                while((line=bufferedReader.readLine())!=null){
//                    System.out.println(line);
//                }
//                bufferedReader.close();
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                while((line=bufferedReader.readLine())!=null){
//                    System.out.println(line);
//                }
//                bufferedReader.close();
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                while((line=bufferedReader.readLine())!=null){
//                    System.out.println(line);
//                }
//                bufferedReader.close();
//            }
//        }
//    }
//
//
//    //close/block cards.
//    public void closeBlockCards(String bankName,String name) throws IOException {
//        switch (bankName){
//            case "bank_ABC" -> {
//                System.out.println("Are you sure you want to block your card!!!");
//                System.out.print("1.\tYes.\n2.\tNo.\n");
//                int yesOrNo = enter.nextInt();
//                switch (yesOrNo) {
//                    case 1 -> {
//                        FileReader fileReader = new FileReader(bank_ABC);
//                        BufferedReader bufferedReader = new BufferedReader(fileReader);
//                        String line;
//                        int countSerialNo = 0;
//                        int choices;
//                        String[] intoArray;
//                        System.out.println("These are the cards under your name. Kindly please choose one of them to block");
//                        HashMap<Integer, Long> cardNumberMappedWithSerialNo = new HashMap<>();
//                        while ((line = bufferedReader.readLine()) != null) {
//                            intoArray = line.split(",");
//                            if (Objects.equals(intoArray[0], name)) {
//                                countSerialNo++;
//                                cardNumberMappedWithSerialNo.put(countSerialNo, Long.parseLong(intoArray[1]));
//                                System.out.println(countSerialNo + ".\t" + intoArray[1]);
//                            }
//                        }
//                        long cardNumber = 0;
//                        choices = enter.nextInt();
//                        int cardPin = 0;
//                        for (Map.Entry<Integer, Long> entry : cardNumberMappedWithSerialNo.entrySet()) {
//                            if (entry.getKey() == choices) {
//                                cardNumber = entry.getValue();
//                                cardPin = getCardPin(cardNumber,bankName);
//                            }
//                        }
//                        int pin;
//                        int pinAttempts = 0;
//                        boolean outOfLoop = false;
//                        do {
//                            System.out.println("Please enter your 4 digit card pin!!!");
//                            pin = enter.nextInt();
//                            pinAttempts++;
//                            if(pin==cardPin) {
//                                fileReader = new FileReader(bank_ABC);
//                                bufferedReader = new BufferedReader(fileReader);
//                                List<String> cardData = new ArrayList<>();
//                                FileWriter fileWriterBlock = new FileWriter(ABCBlockCard, true);
//                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriterBlock);
//                                while ((line = bufferedReader.readLine()) != null) {
//                                    intoArray = line.split(",");
//                                    try {
//                                        if (!Objects.equals(intoArray[1], String.valueOf(cardNumber))) {
//                                            cardData.add(line);
//                                        } else {
//                                            bufferedWriter.write(line);
//                                            bufferedWriter.newLine();
//                                            bufferedWriter.flush();
//                                        }
//                                    } catch (ArrayIndexOutOfBoundsException e) {
//                                        System.out.println();
//                                    }
//                                }
//                                FileWriter fileWriter = new FileWriter(bank_ABC, false);
//                                BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter);
//                                System.out.println("Your card has been successfully blocked!!!");
//                                for (String readCardNumber : cardData) {
//                                    new FileWriter(bank_ABC, true);
//                                    bufferedWriter1.write(readCardNumber);
//                                    bufferedWriter1.newLine();
//                                    bufferedWriter1.flush();
//                                }
//                                fileWriter.close();
//                                fileWriterBlock.close();
//                                bufferedReader.close();
//                                bufferedWriter.close();
//                                outOfLoop=true;
//                            }
//                            if(pinAttempts==3 && !outOfLoop){
//                                System.out.println("You have exhausted your limit");
//                                break;
//                            }
//                        }while(!outOfLoop);
//                    }
//                    case 2 -> System.out.println("It was nice having you, have a great day ahead!!!");
//                    default -> System.out.println("Sorry dear customer there are no such options available");
//                }
//            }
//
//            case "bank_DEF" -> {
//                System.out.println("Are you sure you want to block your card!!!");
//                System.out.print("1.\tYes.\n2.\tNo.\n");
//                int yesOrNo = enter.nextInt();
//                switch (yesOrNo) {
//                    case 1 -> {
//                        FileReader fileReader = new FileReader(bank_DEF);
//                        BufferedReader bufferedReader = new BufferedReader(fileReader);
//                        String line;
//                        int countSerialNo = 0;
//                        int choices;
//                        String[] intoArray;
//                        System.out.println("These are the cards under your name. Kindly please choose one of them to block");
//                        HashMap<Integer, Long> cardNumberMappedWithSerialNo = new HashMap<>();
//                        while ((line = bufferedReader.readLine()) != null) {
//                            intoArray = line.split(",");
//                            if (Objects.equals(intoArray[0], name)) {
//                                countSerialNo++;
//                                cardNumberMappedWithSerialNo.put(countSerialNo, Long.parseLong(intoArray[1]));
//                                System.out.println(countSerialNo + ".\t" + intoArray[1]);
//                            }
//                        }
//                        long cardNumber = 0;
//                        choices = enter.nextInt();
//                        int cardPin = 0;
//                        for (Map.Entry<Integer, Long> entry : cardNumberMappedWithSerialNo.entrySet()) {
//                            if (entry.getKey() == choices) {
//                                cardNumber = entry.getValue();
//                                cardPin = this.getCardPin(cardNumber,bankName);
//                            }
//                        }
//                        int pin;
//                        int pinAttempts = 0;
//                        boolean outOfLoop = false;
//                        do {
//                            System.out.println("Please enter your 4 digit card pin!!!");
//                            pin = enter.nextInt();
//                            pinAttempts++;
//                            if(pin==cardPin) {
//                                fileReader = new FileReader(bank_DEF);
//                                bufferedReader = new BufferedReader(fileReader);
//                                List<String> cardData = new ArrayList<>();
//                                FileWriter fileWriterBlock = new FileWriter(DEFBlockedCards, true);
//                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriterBlock);
//                                while ((line = bufferedReader.readLine()) != null) {
//                                    intoArray = line.split(",");
//                                    try {
//                                        if (!Objects.equals(intoArray[1], String.valueOf(cardNumber))) {
//                                            cardData.add(line);
//                                        } else {
//                                            bufferedWriter.write(line);
//                                            bufferedWriter.newLine();
//                                            bufferedWriter.flush();
//                                        }
//                                    } catch (ArrayIndexOutOfBoundsException e) {
//                                        System.out.println();
//                                    }
//                                }
//                                FileWriter fileWriter = new FileWriter(bank_DEF, false);
//                                BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter);
//                                System.out.println("Your card has been successfully blocked!!!");
//                                for (String readCardNumber : cardData) {
//                                    new FileWriter(bank_DEF, true);
//                                    bufferedWriter1.write(readCardNumber);
//                                    bufferedWriter1.newLine();
//                                    bufferedWriter1.flush();
//                                }
//                                fileWriter.close();
//                                fileWriterBlock.close();
//                                bufferedReader.close();
//                                bufferedWriter.close();
//                                outOfLoop=true;
//                            }
//                            if(pinAttempts==3 && !outOfLoop){
//                                System.out.println("You have exhausted your limit");
//                                break;
//                            }
//                        }while(!outOfLoop);
//                    }
//                    case 2 -> System.out.println("It was nice having you, have a great day ahead!!!");
//                    default -> System.out.println("Sorry dear customer there are no such options available");
//                }
//            }
//
//            case "bank_XYZ" -> {
//                System.out.println("Are you sure you want to block your card!!!");
//                System.out.print("1.\tYes.\n2.\tNo.\n");
//                int yesOrNo = enter.nextInt();
//                switch (yesOrNo) {
//                    case 1 -> {
//                        FileReader fileReader = new FileReader(bank_XYZ);
//                        BufferedReader bufferedReader = new BufferedReader(fileReader);
//                        String line;
//                        int countSerialNo = 0;
//                        int choices;
//                        String[] intoArray;
//                        System.out.println("These are the cards under your name. Kindly please choose one of them to block");
//                        HashMap<Integer, Long> cardNumberMappedWithSerialNo = new HashMap<>();
//                        while ((line = bufferedReader.readLine()) != null) {
//                            intoArray = line.split(",");
//                            if (Objects.equals(intoArray[0], name)) {
//                                countSerialNo++;
//                                cardNumberMappedWithSerialNo.put(countSerialNo, Long.parseLong(intoArray[1]));
//                                System.out.println(countSerialNo + ".\t" + intoArray[1]);
//                            }
//                        }
//                        long cardNumber = 0;
//                        choices = enter.nextInt();
//                        int cardPin = 0;
//                        for (Map.Entry<Integer, Long> entry : cardNumberMappedWithSerialNo.entrySet()) {
//                            if (entry.getKey() == choices) {
//                                cardNumber = entry.getValue();
//                                cardPin = this.getCardPin(cardNumber,bankName);
//                            }
//                        }
//                        int pin;
//                        int pinAttempts = 0;
//                        boolean outOfLoop = false;
//                        do {
//                            System.out.println("Please enter your 4 digit card pin!!!");
//                            pin = enter.nextInt();
//                            pinAttempts++;
//                            if(pin==cardPin) {
//                                fileReader = new FileReader(bank_XYZ);
//                                bufferedReader = new BufferedReader(fileReader);
//                                List<String> cardData = new ArrayList<>();
//                                FileWriter fileWriterBlock = new FileWriter(XYZBlockedCards, true);
//                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriterBlock);
//                                while ((line = bufferedReader.readLine()) != null) {
//                                    intoArray = line.split(",");
//                                    try {
//                                        if (!Objects.equals(intoArray[1], String.valueOf(cardNumber))) {
//                                            cardData.add(line);
//                                        } else {
//                                            bufferedWriter.write(line);
//                                            bufferedWriter.newLine();
//                                            bufferedWriter.flush();
//                                        }
//                                    } catch (ArrayIndexOutOfBoundsException e) {
//                                        System.out.println();
//                                    }
//                                }
//                                FileWriter fileWriter = new FileWriter(bank_XYZ, false);
//                                BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter);
//                                System.out.println("Your card has been successfully blocked!!!");
//                                for (String readCardNumber : cardData) {
//                                    new FileWriter(bank_XYZ, true);
//                                    bufferedWriter1.write(readCardNumber);
//                                    bufferedWriter1.newLine();
//                                    bufferedWriter1.flush();
//                                }
//                                fileWriter.close();
//                                fileWriterBlock.close();
//                                bufferedReader.close();
//                                bufferedWriter.close();
//                                outOfLoop=true;
//                            }
//                            if(pinAttempts==3 && !outOfLoop){
//                                System.out.println("You have exhausted your limit");
//                                break;
//                            }
//                        }while(!outOfLoop);
//                    }
//                    case 2 -> System.out.println("It was nice having you, have a great day ahead!!!");
//                    default -> System.out.println("Sorry dear customer there are no such options available");
//                }
//            }
//        }
//    }
//
//
//    //purchase/buy items
//
//    public void purchaseItemsLevelThree(String userName,String bankName) throws IOException {
//        switch (bankName){
//            case "bank_ABC" -> {
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                int countCreditCards = 0;
//                System.out.println("These are the cards under your name. Kindly please choose one of" +
//                        " them to have your purchase");
//                HashMap<Integer,Long> cardNumberMappedWithSerialNo = new HashMap<>();
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray =  line.split(",");
//                    if(Objects.equals(intoArray[0], userName)){
//                        countCreditCards++;
//                        cardNumberMappedWithSerialNo.put(countCreditCards, Long.parseLong(intoArray[1]));
//                        System.out.println(countCreditCards + ".\t" + intoArray[1]);
//                    }
//                }
//                long cardNumber = 0;
//                int choices = enter.nextInt();
//                int cardPin = 0;
//                for (Map.Entry<Integer,Long> entry : cardNumberMappedWithSerialNo.entrySet()) {
//                    if (entry.getKey() == choices) {
//                        cardNumber = entry.getValue();
//                        cardPin = this.getCardPin(cardNumber,bankName);
//                    }
//                }
//                int pin;
//                int countAttempts = 0;
//                boolean outOfLoop = false;
//                do{
//                    System.out.println("Please enter your 4 digit pin");
//                    pin = enter.nextInt();
//                    countAttempts++;
//                    if(countPinDigitCount(pin)){
//                        if(pin==cardPin)
//                            {
//                                String readLineAgain;
//                                fileReader = new FileReader(bank_ABC);
//                                bufferedReader = new BufferedReader(fileReader);
//                                int spendableAmount = 0;
//                                while((readLineAgain=bufferedReader.readLine())!=null){
//                                    intoArray = readLineAgain.split(",");
//                                    if(cardNumber==Long.parseLong(intoArray[1])){
//                                        spendableAmount = Integer.parseInt(intoArray[3]);
//                                        System.out.println("You have "+spendableAmount+" balance in your account.");
//                                    }
//                                }
//                                System.out.println("We have following items available with us!!!");
//                                System.out.print("1.\tGoggles\tRs-500\n");
//                                System.out.print("2.\tJeans\tRs-1500\n");
//                                System.out.print("3.\tBelt\tRs-950\n");
//                                int choice = enter.nextInt();
//                                int depositAmount = 0;
//                                switch (choice){
//                                    case 1 -> {
//                                        System.out.println("Dear Customer how many goggles you want to purchase?");
//                                        int numbers = enter.nextInt();
//                                        int totalCost;
//                                        if(numbers>=1 && numbers<=10){
//                                            totalCost = numbers*500;
//                                            System.out.println("Your total goggles cost : "+totalCost);
//                                            if(totalCost<=spendableAmount){
//                                                this.updateLevelThreePrice(totalCost,cardNumber, true,
//                                                        depositAmount,bankName);
//                                                System.out.println("Thank you for shopping with BankXYZ");
//                                                outOfLoop = true;
//                                            }
//                                            else{
//                                                System.out.println("You have insufficient amount in your card!!!");
//                                                System.out.println("Dear customer you will be given 3 attempts to deposit the " +
//                                                        "required amount for transaction");
//                                                int depositAttempts = 0;
//                                                do {
//                                                    depositAttempts++;
//                                                    System.out.println("Please enter your require amount");
//                                                    depositAmount = enter.nextInt();
//                                                    if (depositAmount > spendableAmount && depositAmount > totalCost) {
//                                                        this.updateLevelThreePrice(totalCost, cardNumber,
//                                                                false, depositAmount,bankName);
//                                                        outOfLoop = true;
//                                                    }
//                                                    if(depositAttempts==3 && !outOfLoop){
//                                                        System.out.println("You have exhausted your attempts");
//                                                        break;
//                                                    }
//                                                }while(depositAmount<totalCost);
//                                            }
//                                            //if totalCost < amount available in the credit-card the customer won't be able to purchase.
//                                        }else{
//                                            System.out.println("Please provide an appropriate quantity");
//                                        }
//                                    }
//                                    case 2 -> {
//                                        System.out.println("Dear Customer how many jeans you want to purchase?");
//                                        int numbers = enter.nextInt();
//                                        int totalCost;
//                                        if(numbers>=1 && numbers<=10){
//                                            totalCost = numbers*1500;
//                                            System.out.println("Your total jeans cost : "+totalCost);
//                                            if(totalCost<spendableAmount){
//                                                this.updateLevelThreePrice(totalCost,cardNumber,
//                                                        true,depositAmount,bankName);
//                                                System.out.println("Thank you for shopping with bank_ABC");
//                                            }else{
//                                                System.out.println("You have insufficient amount in your card!!!");
//                                                System.out.println("Please enter your require amount");
//                                                depositAmount = enter.nextInt();
//                                                this.updateLevelThreePrice(totalCost,cardNumber,
//                                                        false,depositAmount,bankName);
//                                            }
//                                            outOfLoop = true;
//                                        }else{
//                                            System.out.println("Kindly please provide an appropriate quantity");
//                                        }
//                                    }
//                                    case 3 -> {
//                                        System.out.println("Dear Customer how many Belt you want to purchase?");
//                                        int numbers = enter.nextInt();
//                                        int totalCost;
//                                        if(numbers>1 && numbers<1000){
//                                            totalCost = numbers*950;
//                                            System.out.println("Your total belt cost : "+totalCost);
//                                            if(totalCost<spendableAmount){
//                                                this.updateLevelThreePrice(totalCost,cardNumber,
//                                                        true,depositAmount,bankName);
//                                                System.out.println("Thank you for shopping with bank_ABC");
//                                            }else{
//                                                System.out.println("You have insufficient amount in your card!!!");
//                                                System.out.println("Please enter your require amount");
//                                                depositAmount =  enter.nextInt();
//                                                this.updateLevelThreePrice(totalCost,cardNumber,
//                                                        false,depositAmount,bankName);
//                                            }
//                                            outOfLoop = true;
//                                        }else{
//                                            System.out.println("Kindly please provide an appropriate quantity");
//                                        }
//                                    }
//                                    default -> System.out.println("No such item available!!!");
//                                }
//                            }
//                        }
//                    if(countAttempts==3 && !outOfLoop){
//                        System.out.println("You have exhausted your limit");
//                        break;
//                    }
//                }while(!outOfLoop);
//            }
//            case "bank_DEF" -> {
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                int countCreditCards = 0;
//                System.out.println("These are the cards under your name. Kindly please choose one of" +
//                        " them to have your purchase");
//                HashMap<Integer,Long> cardNumberMappedWithSerialNo = new HashMap<>();
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray =  line.split(",");
//                    if(Objects.equals(intoArray[0], userName)){
//                        countCreditCards++;
//                        cardNumberMappedWithSerialNo.put(countCreditCards, Long.parseLong(intoArray[1]));
//                        System.out.println(countCreditCards + ".\t" + intoArray[1]);
//                    }
//                }
//                long cardNumber = 0;
//                int choices = enter.nextInt();
//                int cardPin = 0;
//                for (Map.Entry<Integer,Long> entry : cardNumberMappedWithSerialNo.entrySet()) {
//                    if (entry.getKey() == choices) {
//                        cardNumber = entry.getValue();
//                        cardPin = this.getCardPin(cardNumber,bankName);
//                    }
//                }
//                int pin;
//                int countAttempts = 0;
//                boolean outOfLoop = false;
//                do{
//                    System.out.println("Please enter your 4 digit pin");
//                    pin = enter.nextInt();
//                    countAttempts++;
//                    if(countPinDigitCount(pin)){
//                        if(pin==cardPin)
//                        {
//                            String readLineAgain;
//                            fileReader = new FileReader(bank_DEF);
//                            bufferedReader = new BufferedReader(fileReader);
//                            int spendableAmount = 0;
//                            while((readLineAgain=bufferedReader.readLine())!=null){
//                                intoArray = readLineAgain.split(",");
//                                if(cardNumber==Long.parseLong(intoArray[1])){
//                                    spendableAmount = Integer.parseInt(intoArray[3]);
//                                    System.out.println("You have "+spendableAmount+" balance in your account.");
//                                }
//                            }
//                            System.out.println("We have following items available with us!!!");
//                            System.out.print("1.\tGoggles\tRs-500\n");
//                            System.out.print("2.\tJeans\tRs-1500\n");
//                            System.out.print("3.\tBelt\tRs-950\n");
//                            int choice = enter.nextInt();
//                            int depositAmount = 0;
//                            switch (choice){
//                                case 1 -> {
//                                    System.out.println("Dear Customer how many goggles you want to purchase?");
//                                    int numbers = enter.nextInt();
//                                    int totalCost;
//                                    if(numbers>=1 && numbers<=10){
//                                        totalCost = numbers*500;
//                                        System.out.println("Your total goggles cost : "+totalCost);
//                                        if(totalCost<=spendableAmount){
//                                            this.updateLevelThreePrice(totalCost,cardNumber, true,
//                                                    depositAmount,bankName);
//                                            System.out.println("Thank you for shopping with BankDEF");
//                                            outOfLoop = true;
//                                        }
//                                        else{
//                                            System.out.println("You have insufficient amount in your card!!!");
//                                            System.out.println("Dear customer you will be given 3 attempts to deposit the " +
//                                                    "required amount for transaction");
//                                            int depositAttempts = 0;
//                                            do {
//                                                depositAttempts++;
//                                                System.out.println("Please enter your require amount");
//                                                depositAmount = enter.nextInt();
//                                                if (depositAmount > spendableAmount && depositAmount > totalCost) {
//                                                    this.updateLevelThreePrice(totalCost, cardNumber,
//                                                            false, depositAmount,bankName);
//                                                    outOfLoop = true;
//                                                }
//                                                if(depositAttempts==3 && !outOfLoop){
//                                                    System.out.println("You have exhausted your attempts");
//                                                    break;
//                                                }
//                                            }while(depositAmount<totalCost);
//                                        }
//                                        //if totalCost < amount available in the credit-card the customer won't be able to purchase.
//                                    }else{
//                                        System.out.println("Please provide an appropriate quantity");
//                                    }
//                                }
//                                case 2 -> {
//                                    System.out.println("Dear Customer how many jeans you want to purchase?");
//                                    int numbers = enter.nextInt();
//                                    int totalCost;
//                                    if(numbers>=1 && numbers<=10){
//                                        totalCost = numbers*1500;
//                                        System.out.println("Your total jeans cost : "+totalCost);
//                                        if(totalCost<spendableAmount){
//                                            this.updateLevelThreePrice(totalCost,cardNumber,true,depositAmount,bankName);
//                                            System.out.println("Thank you for shopping with bank_DEF");
//                                        }else{
//                                            System.out.println("You have insufficient amount in your card!!!");
//                                            System.out.println("Please enter your require amount");
//                                            depositAmount = enter.nextInt();
//                                            this.updateLevelThreePrice(totalCost,cardNumber,
//                                                    false,depositAmount,bankName);
//                                        }
//                                        outOfLoop = true;
//                                    }else{
//                                        System.out.println("Kindly please provide an appropriate quantity");
//                                    }
//                                }
//                                case 3 -> {
//                                    System.out.println("Dear Customer how many Belt you want to purchase?");
//                                    int numbers = enter.nextInt();
//                                    int totalCost;
//                                    if(numbers>1 && numbers<1000){
//                                        totalCost = numbers*950;
//                                        System.out.println("Your total belt cost : "+totalCost);
//                                        if(totalCost<spendableAmount){
//                                            this.updateLevelThreePrice(totalCost,cardNumber,
//                                                    true,depositAmount,bankName);
//                                            System.out.println("Thank you for shopping with bank_DEF");
//                                        }else{
//                                            System.out.println("You have insufficient amount in your card!!!");
//                                            System.out.println("Please enter your require amount");
//                                            depositAmount =  enter.nextInt();
//                                            this.updateLevelThreePrice(totalCost,cardNumber,
//                                                    false,depositAmount,bankName);
//                                        }
//                                        outOfLoop = true;
//                                    }else{
//                                        System.out.println("Kindly please provide an appropriate quantity");
//                                    }
//                                }
//                                default -> System.out.println("No such item available!!!");
//                            }
//                        }
//                    }
//                    if(countAttempts==3 && !outOfLoop){
//                        System.out.println("You have exhausted your limit");
//                        break;
//                    }
//                }while(!outOfLoop);
//            }
//            case "bank_XYZ" -> {
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String line;
//                String[] intoArray;
//                int countCreditCards = 0;
//                System.out.println("These are the cards under your name. Kindly please choose one of" +
//                        " them to have your purchase");
//                HashMap<Integer,Long> cardNumberMappedWithSerialNo = new HashMap<>();
//                while((line=bufferedReader.readLine())!=null){
//                    intoArray =  line.split(",");
//                    if(Objects.equals(intoArray[0], userName)){
//                        countCreditCards++;
//                        cardNumberMappedWithSerialNo.put(countCreditCards, Long.parseLong(intoArray[1]));
//                        System.out.println(countCreditCards + ".\t" + intoArray[1]);
//                    }
//                }
//                long cardNumber = 0;
//                int choices = enter.nextInt();
//                int cardPin = 0;
//                for (Map.Entry<Integer,Long> entry : cardNumberMappedWithSerialNo.entrySet()) {
//                    if (entry.getKey() == choices) {
//                        cardNumber = entry.getValue();
//                        cardPin = this.getCardPin(cardNumber,bankName);
//                    }
//                }
//                int pin;
//                int countAttempts = 0;
//                boolean outOfLoop = false;
//                do{
//                    System.out.println("Please enter your 4 digit pin");
//                    pin = enter.nextInt();
//                    countAttempts++;
//                    if(countPinDigitCount(pin)){
//                        if(pin==cardPin)
//                        {
//                            String readLineAgain;
//                            fileReader = new FileReader(bank_XYZ);
//                            bufferedReader = new BufferedReader(fileReader);
//                            int spendableAmount = 0;
//                            while((readLineAgain=bufferedReader.readLine())!=null){
//                                intoArray = readLineAgain.split(",");
//                                if(cardNumber==Long.parseLong(intoArray[1])){
//                                    spendableAmount = Integer.parseInt(intoArray[3]);
//                                    System.out.println("You have "+spendableAmount+" balance in your account.");
//                                }
//                            }
//                            System.out.println("We have following items available with us!!!");
//                            System.out.print("1.\tGoggles\tRs-500\n");
//                            System.out.print("2.\tJeans\tRs-1500\n");
//                            System.out.print("3.\tBelt\tRs-950\n");
//                            int choice = enter.nextInt();
//                            int depositAmount = 0;
//                            switch (choice){
//                                case 1 -> {
//                                    System.out.println("Dear Customer how many goggles you want to purchase?");
//                                    int numbers = enter.nextInt();
//                                    int totalCost;
//                                    if(numbers>=1 && numbers<=10){
//                                        totalCost = numbers*500;
//                                        System.out.println("Your total goggles cost : "+totalCost);
//                                        if(totalCost<=spendableAmount){
//                                            this.updateLevelThreePrice(totalCost,cardNumber, true,
//                                                    depositAmount,bankName);
//                                            System.out.println("Thank you for shopping with BankXYZ");
//                                            outOfLoop = true;
//                                        }
//                                        else{
//                                            System.out.println("You have insufficient amount in your card!!!");
//                                            System.out.println("Dear customer you will be given 3 attempts to deposit the " +
//                                                    "required amount for transaction");
//                                            int depositAttempts = 0;
//                                            do {
//                                                depositAttempts++;
//                                                System.out.println("Please enter your require amount");
//                                                depositAmount = enter.nextInt();
//                                                if (depositAmount > spendableAmount && depositAmount > totalCost) {
//                                                    this.updateLevelThreePrice(totalCost, cardNumber,
//                                                            false, depositAmount,bankName);
//                                                    outOfLoop = true;
//                                                }
//                                                if(depositAttempts==3 && !outOfLoop){
//                                                    System.out.println("You have exhausted your attempts");
//                                                    break;
//                                                }
//                                            }while(depositAmount<totalCost);
//                                        }
//                                        //if totalCost < amount available in the credit-card the customer won't be able to purchase.
//                                    }else{
//                                        System.out.println("Please provide an appropriate quantity");
//                                    }
//                                }
//                                case 2 -> {
//                                    System.out.println("Dear Customer how many jeans you want to purchase?");
//                                    int numbers = enter.nextInt();
//                                    int totalCost;
//                                    if(numbers>=1 && numbers<=10){
//                                        totalCost = numbers*1500;
//                                        System.out.println("Your total jeans cost : "+totalCost);
//                                        if(totalCost<spendableAmount){
//                                            this.updateLevelThreePrice(totalCost,cardNumber,
//                                                    true,depositAmount,bankName);
//                                            System.out.println("Thank you for shopping with bank_XYZ");
//                                        }else{
//                                            System.out.println("You have insufficient amount in your card!!!");
//                                            System.out.println("Please enter your require amount");
//                                            depositAmount = enter.nextInt();
//                                            this.updateLevelThreePrice(totalCost,cardNumber,
//                                                    false,depositAmount,bankName);
//                                        }
//                                        outOfLoop = true;
//                                    }else{
//                                        System.out.println("Kindly please provide an appropriate quantity");
//                                    }
//                                }
//                                case 3 -> {
//                                    System.out.println("Dear Customer how many Belt you want to purchase?");
//                                    int numbers = enter.nextInt();
//                                    int totalCost;
//                                    if(numbers>1 && numbers<1000){
//                                        totalCost = numbers*950;
//                                        System.out.println("Your total belt cost : "+totalCost);
//                                        if(totalCost<spendableAmount){
//                                            this.updateLevelThreePrice(totalCost,cardNumber,
//                                                    true,depositAmount,bankName);
//                                            System.out.println("Thank you for shopping with bank_XYZ");
//                                        }else{
//                                            System.out.println("You have insufficient amount in your card!!!");
//                                            System.out.println("Please enter your require amount");
//                                            depositAmount =  enter.nextInt();
//                                            this.updateLevelThreePrice(totalCost,cardNumber,
//                                                    false,depositAmount,bankName);
//                                        }
//                                        outOfLoop = true;
//                                    }else{
//                                        System.out.println("Kindly please provide an appropriate quantity");
//                                    }
//                                }
//                                default -> System.out.println("No such item available!!!");
//                            }
//                        }
//                    }
//                    if(countAttempts==3 && !outOfLoop){
//                        System.out.println("You have exhausted your limit");
//                        break;
//                    }
//                }while(!outOfLoop);
//            }
//        }
//    }
//
//    public void updateLevelThreePrice(int price,Long cardNumber,boolean subtract,int depositAmount,String bankName)
//            throws IOException {
//        switch (bankName){
//            case "bank_ABC" -> {
//                List<String> dataToUpdate = new ArrayList<>();
//                FileReader fileReader = new FileReader(bank_ABC);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                FileWriter fileWriter = new FileWriter(bank_ABC,true);
//                String line;
//                String[] intoArray;
//                int updatingOperation;
//                while ((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Long.parseLong(intoArray[1])==cardNumber){
//                        if(!subtract){
//                            updatingOperation = Integer.parseInt(intoArray[3])+depositAmount;
//                            updatingOperation = updatingOperation-price;
//                        }else{
//                            updatingOperation = Integer.parseInt(intoArray[3])-price;
//                        }
//                        intoArray[3] = String.valueOf(updatingOperation);
//                        dataToUpdate.add(intoArray[0]+","+intoArray[1]+","+intoArray[2]+","+intoArray[3]);
//                    }else{
//                        dataToUpdate.add(line);
//                    }
//                }
//                new FileWriter(bank_ABC,false);
//                new FileWriter(bank_ABC,true);
//                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                for (String readData : dataToUpdate) {
//                    bufferedWriter.write(readData);
//                    bufferedWriter.newLine();
//                    bufferedWriter.flush();
//                }
//                bufferedReader.close();
//                bufferedWriter.close();
//            }
//            case "bank_DEF" -> {
//                List<String> dataToUpdate = new ArrayList<>();
//                FileReader fileReader = new FileReader(bank_DEF);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                FileWriter fileWriter = new FileWriter(bank_DEF,true);
//                String line;
//                String[] intoArray;
//                int updatingOperation;
//                while ((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Long.parseLong(intoArray[1])==cardNumber){
//                        if(!subtract){
//                            updatingOperation = Integer.parseInt(intoArray[3])+depositAmount;
//                            updatingOperation = updatingOperation-price;
//                        }else{
//                            updatingOperation = Integer.parseInt(intoArray[3])-price;
//                        }
//                        intoArray[3] = String.valueOf(updatingOperation);
//                        dataToUpdate.add(intoArray[0]+","+intoArray[1]+","+intoArray[2]+","+intoArray[3]);
//                    }else{
//                        dataToUpdate.add(line);
//                    }
//                }
//                new FileWriter(bank_DEF,false);
//                new FileWriter(bank_DEF,true);
//                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                for (String readData : dataToUpdate) {
//                    bufferedWriter.write(readData);
//                    bufferedWriter.newLine();
//                    bufferedWriter.flush();
//                }
//                bufferedReader.close();
//                bufferedWriter.close();
//            }
//            case "bank_XYZ" -> {
//                List<String> dataToUpdate = new ArrayList<>();
//                FileReader fileReader = new FileReader(bank_XYZ);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                FileWriter fileWriter = new FileWriter(bank_XYZ,true);
//                String line;
//                String[] intoArray;
//                int updatingOperation;
//                while ((line=bufferedReader.readLine())!=null){
//                    intoArray = line.split(",");
//                    if(Long.parseLong(intoArray[1])==cardNumber){
//                        if(!subtract){
//                            updatingOperation = Integer.parseInt(intoArray[3])+depositAmount;
//                            updatingOperation = updatingOperation-price;
//                        }else{
//                            updatingOperation = Integer.parseInt(intoArray[3])-price;
//                        }
//                        intoArray[3] = String.valueOf(updatingOperation);
//                        dataToUpdate.add(intoArray[0]+","+intoArray[1]+","+intoArray[2]+","+intoArray[3]);
//                    }else{
//                        dataToUpdate.add(line);
//                    }
//                }
//                new FileWriter(bank_XYZ,false);
//                new FileWriter(bank_XYZ,true);
//                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                for (String readData : dataToUpdate) {
//                    bufferedWriter.write(readData);
//                    bufferedWriter.newLine();
//                    bufferedWriter.flush();
//                }
//                bufferedReader.close();
//                bufferedWriter.close();
//            }
//        }
//
//    }
//}
