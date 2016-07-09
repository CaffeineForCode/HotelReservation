package mrigankHotelReservation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User:mrigankmittal
 * Date:6/6/16
 * Time:9:57 PM
 * Project:reservationHotel
 */


public class Menu {
    /*
    Run the menu. If the menu terminates so does the program.
    */
    public void menu(Hotels hot, StartHere startHere) throws IOException {
        boolean run = true;
        Scanner input = new Scanner(System.in);
        while(run){
            boolean continueInput = true;

            System.out.println("Hi welcome to the hotels booking system. Please enter a selection followed by enter:\n" + "Choose a hotel:" +
                    "3) Star, 4) Star, 5) Star or Q)uit");
            String choice = input.next().toUpperCase();
            do{
                try{
                    if(choice.equals("3")|| choice.equals("4")|| choice.equals("5") || choice.equals("Q") ){
                        continueInput  = false;
                    }else{
                        throw new InputMismatchException("Not valid choice");
                    }
                }catch(InputMismatchException ex){
                    System.out.println("Try Again (Incorrect input)");
                    System.out.println("Hi welcome to the hotels booking system. Please enter a selection by choosing a letter followed by enter:\n" + "Choose a hotel:" +
                            "3) Star, 4) Star, 5) Star");
                    input.nextLine();
                    choice = input.next().toUpperCase();
                }
            }while(continueInput);
            if(choice.equals("Q")){
                System.out.println("Thank you for using the Hotels booking system. Goodbye.");
                break;
            }
            hot.setChoice(choice);



            System.out.println("Log in as: S)upervisor, C)ustomer, Q)uit");
            choice = input.next().toUpperCase();
            continueInput = true;
            do{
                try{
                    if(choice.equals("S")|| choice.equals("C") || choice.equals("Q")){
                        continueInput  = false;
                    }else{
                        throw new InputMismatchException("Not valid choice");
                    }
                }catch(InputMismatchException ex){
                    System.out.println("Try Again (Incorrect input)");
                    System.out.println("Log in as: S)upervisor, C)ustomer, Q)uit");;
                    input.nextLine();
                    choice = input.next().toUpperCase();
                }
            }while(continueInput);


            if(choice.equals("S")){
                System.out.println("Welcome please enter your password:");
                if(input.next().equals("mrigank")){
                    System.out.println("Welcome please choose an option: N)ew Reservation, C)ancellation, Check I)n, Check O)ut");
                    choice = input.next().toUpperCase();
                    continueInput = true;
                    do{
                        try{
                            if(choice.equals("N")|| choice.equals("C") || choice.equals("I") || choice.equals("O") ){
                                continueInput  = false;
                            }else{
                                throw new InputMismatchException("Not valid choice");
                            }
                        }catch(InputMismatchException ex){
                            System.out.println("Try Again (Incorrect input)");
                            System.out.println("Welcome please choose an option: N)ew Reservation, C)ancellation, Check I)n, Check O)ut");
                            input.nextLine();
                            choice = input.next().toUpperCase();
                        }
                    }while(continueInput);



                    if(choice.equals("N")){
                        resMenu(hot, startHere);
                    }else if(choice.equals("C")){

                        System.out.println("Please enter your Reservation number:");
                        int resNum = 1;
                        continueInput = true;
                        do{
                            try{
                                resNum = input.nextInt();
                                if(startHere.getData().cancellations(resNum, hot, startHere)){
                                    System.out.println("Reservation removed from the Database.");
                                    startHere.getRead().writeReservation(hot, startHere.getData());
                                }else{
                                    System.out.println("Reservation Number not found!");
                                }
                                continueInput  = false;

                            }catch(InputMismatchException ex){
                                System.out.println("Try Again (Incorrect input: Enter an Integer)");
                                System.out.println("Please enter your Reservation number:");
                                input.nextLine();
                            }
                        }while(continueInput);

                    }else if(choice.equals("I")){
                        System.out.println("Please enter your Reservation number:");
                        int resNum = 1;
                        continueInput = true;
                        do{
                            try{
                                resNum = input.nextInt();
                                if(startHere.getCheckData().checkIn(resNum, startHere.getData())){
                                    System.out.println("Checked In");
                                    startHere.getRead().writeReservation(hot, startHere.getData());
                                    startHere.getRead().writeCheckIns(hot, startHere.getCheckData());
                                }else{
                                    System.out.println("Can't check in, either your here too early or the reservation number is wrong.");
                                }
                                continueInput  = false;

                            }catch(InputMismatchException ex){
                                System.out.println("Try Again (Incorrect input: Enter an Integer)");
                                System.out.println("Please enter your Reservation number:");
                                input.nextLine();
                            }
                        }while(continueInput);

                    }else if(choice.equals("O")){
                        System.out.println("Please enter your Reservation number:");
                        int resNum = 1;
                        continueInput = true;
                        do{
                            try{
                                resNum = input.nextInt();
                                if(startHere.getCheckData().checkOut(resNum)){
                                    System.out.println("Checked Out");
                                    startHere.getRead().writeReservation(hot, startHere.getData());
                                    startHere.getRead().writeCheckIns(hot, startHere.getCheckData());
                                    startHere.getRead().writeCheckOuts(hot, startHere.getCheckData());
                                }else{
                                    System.out.println("Can't check out the reservation number is wrong.");
                                }
                                continueInput  = false;

                            }catch(InputMismatchException ex){
                                System.out.println("Try Again (Incorrect input: Enter an Integer)");
                                System.out.println("Please enter your Reservation number:");
                                input.nextLine();
                            }
                        }while(continueInput);
                    }
                }
            }else if(choice.equals("C")){
                System.out.println("Welcome please choose an option: N)ew Reservation, C)ancellation");
                choice = input.next().toUpperCase();
                continueInput = true;
                do{
                    try{
                        if(choice.equals("N")|| choice.equals("C")){
                            continueInput  = false;
                        }else{
                            throw new InputMismatchException("Not valid choice");
                        }
                    }catch(InputMismatchException ex){
                        System.out.println("Try Again (Incorrect input)");
                        System.out.println("Welcome please choose an option: N)ew Reservation, C)ancellation");
                        input.nextLine();
                        choice = input.next().toUpperCase();
                    }
                }while(continueInput);

                if(choice.equals("N")){
                    resMenu(hot, startHere);
                }else if(choice.equals("C")){


                    System.out.println("Please enter your Reservation number:");
                    int resNum = 1;
                    continueInput = true;
                    do{
                        try{
                            resNum = input.nextInt();
                            if(startHere.getData().cancellations(resNum, hot, startHere)){
                                System.out.println("Reservation removed from the Database.");
                                startHere.getRead().writeReservation(hot, startHere.getData());
                            }else{
                                System.out.println("Reservation Number not found!");
                            }
                            continueInput  = false;

                        }catch(InputMismatchException ex){
                            System.out.println("Try Again (Incorrect input: Enter an Integer)");
                            System.out.println("Please enter your Reservation number:");
                            input.nextLine();
                        }
                    }while(continueInput);
                }
            }else if(choice.equals("Q")){
                if(choice.equals("Q")){
                    System.out.println("Thank you for using the  Hotels booking system. Goodbye.");
                    break;
                }
            }
        }
    }

    /*
    Menu for creating user reservations.
    */
    public void resMenu(Hotels hot, StartHere startHere){
        boolean run = true;
        Scanner input = new Scanner(System.in);
        startHere.getRead().printInfo();
        System.out.println("Above is our rates and hotels available for booking.");
        while(run){
            boolean available = true;
            while(available){

                System.out.println("Type of room would you like?:");
                ArrayList<String> rumTypes = new ArrayList<String>();
                rumTypes = hot.getUniqueRoomTypes(hot.getArray(hot.getChoice()));
                for(int i = 0; i < rumTypes.size(); i++){
                    System.out.println(i + ")" + rumTypes.get(i));
                }
                String selection = input.next().toUpperCase();
                if(rumTypes.size() == 4){
                    boolean continueInput = true;
                    do{
                        try{
                            if(selection.equals("0") || selection.equals("1") || selection.equals("2") || selection.equals("3")){
                                continueInput  = false;
                            }else{
                                throw new InputMismatchException("Not valid choice");
                            }
                        }catch(InputMismatchException ex){
                            System.out.println("Try Again (Incorrect input)");
                            for(int i = 0; i < rumTypes.size(); i++){
                                System.out.println(i + ")" + rumTypes.get(i));
                            }
                            input.nextLine();
                            selection = input.next().toUpperCase();
                        }
                    }while(continueInput);

                }else{

                    boolean continueInput = true;
                    do{
                        try{
                            if(selection.equals("0") || selection.equals("1") || selection.equals("2")){
                                continueInput  = false;
                            }else{
                                throw new InputMismatchException("Not valid choice");
                            }
                        }catch(InputMismatchException ex){
                            System.out.println("Try Again (Incorrect input)");
                            for(int i = 0; i < rumTypes.size(); i++){
                                System.out.println(i + ")" + rumTypes.get(i));
                            }
                            input.nextLine();
                            selection = input.next().toUpperCase();
                        }
                    }while(continueInput);
                }
                int select = Integer.parseInt(selection);
                String roomTypes = rumTypes.get(select);


                System.out.println("Number of rooms would you like?:");
                int roomsNum = 1;
                boolean continueInput = true;
                do{
                    try{
                        roomsNum = input.nextInt();
                        if(roomsNum > hot.getMaxRooms(roomTypes)){
                            throw new InputMismatchException("Too Many Rooms.");
                        }else if(roomsNum < 1){
                            throw new InputMismatchException("Must be at least one Room.");
                        }
                        continueInput  = false;

                    }catch(InputMismatchException ex){
                        System.out.println("Try Again (Incorrect input:" + ex +")");
                        System.out.println("Number of rooms would you like?:");
                        input.nextLine();
                    }
                }while(continueInput);


                System.out.println("Planned arrival date in the format(DD/MM/YYYY):");
                String from = input.next();
                while(startHere.isDateInFuture(from) == false){
                    System.out.println("Planned arrival date format(DD/MM/YYYY):");
                    input.nextLine();
                    from = input.next();
                }

                System.out.println("Number of night/nights would you like to stay?:");
                int nightsNum = 1;
                continueInput = true;

                do{
                    try{
                        nightsNum = input.nextInt();
                        if(nightsNum < 1){
                            throw new InputMismatchException("Must be at least one Night.");
                        }
                        continueInput  = false;

                    }catch(InputMismatchException ex){
                        System.out.println("Try Again (Incorrect input:" + ex +")");
                        System.out.println("Number of night/nights would you like to stay?:");
                        input.nextLine();
                    }
                }while(continueInput);


                System.out.println("Please enter your name:");
                input.nextLine();
                String name = input.nextLine();

                System.out.println("Ok. Do you want a Booking Y or N");
                String choice = input.next().toUpperCase();
                boolean resType = true;



                if(choice.equals("Y")){
                    System.out.println("Please enter the number of Adults:");
                    int adults = 1;
                    continueInput = true;
                    do{
                        try{
                            adults = input.nextInt();
                            if(adults > hot.getMaxAdults(roomTypes)){
                                throw new InputMismatchException("Too Many Adults.");
                            }else if(adults < 1){
                                throw new InputMismatchException("Must be at least one Adult.");
                            }
                            continueInput  = false;

                        }catch(InputMismatchException ex){
                            System.out.println("Try Again (Incorrect input: " + ex +")");
                            System.out.println("Please enter the number of Adults:");
                            input.nextLine();
                        }
                    }while(continueInput);


                    System.out.println("Please enter the number of children:");
                    int children = 1;

                    continueInput = true;
                    do{
                        try{
                            children = input.nextInt();
                            if(children > hot.getMaxChildren(roomTypes)){
                                throw new InputMismatchException("Too Many children");
                            }else if(children < 0){
                                throw new InputMismatchException("Cant have a minus number.");
                            }
                            continueInput  = false;

                        }catch(InputMismatchException ex){
                            System.out.println("Try Again (Incorrect input: " + ex +")");
                            System.out.println("Please enter the number of Children:");
                            input.nextLine();
                        }
                    }while(continueInput);

                    System.out.println("Would you like breakfast: Y)es or N)o:");
                    boolean breakfast = false;

                    choice = input.next().toUpperCase();
                    continueInput = true;
                    do{
                        try{
                            if(choice.equals("Y")|| choice.equals("N")){
                                continueInput  = false;
                            }else{
                                throw new InputMismatchException("Not valid choice");
                            }
                        }catch(InputMismatchException ex){
                            System.out.println("Try Again (Incorrect input)");
                            System.out.println("Would you like breakfast: Y)es or N)o:");
                            input.nextLine();
                            choice = input.next().toUpperCase();
                        }
                    }while(continueInput);

                    if(choice.equals("Y")){
                        breakfast = true;
                    }else if(choice.equals("N")){
                        breakfast = false;
                    }

                    Reservation newRes = startHere.createRes(hot, name, from, nightsNum, roomsNum, roomTypes, adults, children, breakfast, 0.0);
                    double totalCost = startHere.getTotalCost(newRes, hot);
                    System.out.println("Total Cost: " + totalCost + "\nWould you like to book this room? Y)es N)o");
                    choice = input.next().toUpperCase();
                    continueInput = true;
                    do{
                        try{
                            if(choice.equals("Y") || choice.equals("N")){
                                continueInput  = false;
                            }else{
                                throw new InputMismatchException("Not valid choice");
                            }
                        }catch(InputMismatchException ex){
                            System.out.println("Try Again (Incorrect input)");
                            System.out.println("Would you like to book this room? Y)es N)o");
                            input.nextLine();
                            choice = input.next().toUpperCase();
                        }
                    }while(continueInput);

                    if(choice.equals("Y")) {

                        System.out.println("How much of a deposit would you like to pay?:"); //Make sure less than cost
                        double deposit = 0.00;

                        continueInput = true;
                        do {
                            try {
                                deposit = input.nextDouble();
                                if (deposit > totalCost) {
                                    throw new InputMismatchException("Deposit too large");
                                } else if (deposit < 0) {
                                    throw new InputMismatchException("Cant have a minus number.");
                                }
                                newRes.setDeposit(deposit);
                                continueInput = false;

                            } catch (InputMismatchException ex) {
                                System.out.println("Try Again (Incorrect input: " + ex + ")");
                                System.out.println("How much of a deposit would you like to pay?:");
                                input.nextLine();
                            }
                        } while (continueInput);

                        if (startHere.addToList(newRes, hot)) {
                            System.out.println("Thank you for your reservation. Your reservation number is " + newRes.getNumber() + " please remember it for cancellations. Have a good stay!");
                            System.out.println();
                            run = false;
                        } else {
                            System.out.println("We have no available rooms at the moment, sorry.");
                            System.out.println();
                        }
                    }
                    else{
                        System.out.println("Thank you for using the Hotels booking system. Goodbye.");
                        break;
                    }
                }else if(choice.equals("N")){
                    run = false;
                }
                break;
            }
        }
    }
}