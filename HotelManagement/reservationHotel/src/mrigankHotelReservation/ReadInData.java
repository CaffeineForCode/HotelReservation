package mrigankHotelReservation;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User:mrigankmittal
 * Date:6/6/16
 * Time:4:32 PM
 * Project:reservationHotel
 */

public class ReadInData {
    private String[][] info;
    private String[][] res;

    /*
    Reads in Hotels.csv file, splits each line using a comma delimiter. Puts that info into a 2D array and returned.
    */
    public String[][] readHotelFile() throws FileNotFoundException
    {
        java.io.File file = new java.io.File("/Users/mrigankmittal/Desktop/files/Hotels.csv");
        Scanner input = new Scanner(file);

        String line;
        this.info = new String[12][12];
        int z = 0;
        while(input.hasNext()){
            line = input.nextLine();
            this.info[z] = line.split(",");
            z++;
        }
        input.close();
        return info;
    }

    /*
    Reads in res.csv file, splits each line using a comma delimiter. Puts that info into a 2D array and returned.
    */
    public String[][] readResFile() throws FileNotFoundException
    {
        java.io.File file = new java.io.File("/Users/mrigankmittal/Desktop/files/res.csv");

        Scanner count = new Scanner(file);
        String line;
        @SuppressWarnings("unused")
        String c;
        int z = 0;
        while(count.hasNext()){
            c = count.nextLine();
            z++;
        }
        count.close();
        Scanner input = new Scanner(file);
        this.res = new String[z][11];
        z = 0;
        while(input.hasNext()){
            line = input.nextLine();
            this.res[z] = line.split(",");
            z++;
        }
        input.close();
        return res;
    }

    /*
    Reads in checkin.csv file, splits each line using a comma delimiter.  Puts that info into a 2D array and returned.
    */
    public String[][] checkInFile() throws FileNotFoundException
    {
        java.io.File file = new java.io.File("/Users/mrigankmittal/Desktop/files/checkin.csv");

        Scanner count = new Scanner(file);
        String line;
        @SuppressWarnings("unused")
        String c;
        int z = 0;
        while(count.hasNext()){
            c = count.nextLine();
            z++;
        }
        count.close();
        Scanner input = new Scanner(file);
        this.res = new String[z][11];
        z = 0;
        while(input.hasNext()){
            line = input.nextLine();
            this.res[z] = line.split(",");
            z++;
        }
        input.close();
        return res;
    }

    /*
    Reads in checkout.csv file, splits each line using a comma delimiter.  Puts that info into a 2D array and returned.
    */
    public String[][] checkOutFile() throws FileNotFoundException
    {
        java.io.File file = new java.io.File("/Users/mrigankmittal/Desktop/files/checkout.csv");

        Scanner count = new Scanner(file);
        String line;
        @SuppressWarnings("unused")
        String c;
        int z = 0;
        while(count.hasNext()){
            c = count.nextLine();
            z++;
        }
        count.close();
        Scanner input = new Scanner(file);
        this.res = new String[z][11];
        z = 0;
        while(input.hasNext()){
            line = input.nextLine();
            this.res[z] = line.split(",");
            z++;
        }
        input.close();
        return res;
    }
    /*
    Reads in cancellations.csv file, splits each line using a comma delimiter.  Puts that info into a 2D array and returned.
    */
    public String[][] cancellationsFile() throws FileNotFoundException
    {
        java.io.File file = new java.io.File("/Users/mrigankmittal/Desktop/files/cancellations.csv");

        Scanner count = new Scanner(file);
        String line;
        @SuppressWarnings("unused")
        String c;
        int z = 0;
        while(count.hasNext()){
            c = count.nextLine();
            z++;
        }
        count.close();
        Scanner input = new Scanner(file);
        this.res = new String[z][11];
        z = 0;
        while(input.hasNext()){
            line = input.nextLine();
            this.res[z] = line.split(",");
            z++;
        }
        input.close();
        return res;
    }

    /*
    Writes out res.csv file in comma separated format.
    */
    public void writeReservation(Hotels hot, ReservationData data){
        try{
            FileWriter writer = new FileWriter("/Users/mrigankmittal/Desktop/files/res.csv");
            writer.write("Reservation Number");
            writer.write(",");
            writer.write("Name");
            writer.write(",");
            writer.write("Date From");
            writer.write(",");
            writer.write("Date To");
            writer.write(",");
            writer.write("Number of Nights");
            writer.write(",");
            writer.write("Number of Rooms");
            writer.write(",");
            writer.write("Room Type");
            writer.write(",");
            writer.write("Number of Adults");
            writer.write(",");
            writer.write("Number of Children");
            writer.write(",");
            writer.write("Breakfast");
            writer.write(",");
            writer.write("Deposit");
            writer.write("\n");

            for(int i = 0; i < data.getList().size(); i++){
                writer.write(String.valueOf(data.getList().get(i).getNumber()));
                writer.write(",");
                writer.write(data.getList().get(i).getName());
                writer.write(",");
                writer.write(data.getList().get(i).getDateF());
                writer.write(",");
                writer.write(data.getList().get(i).getDateT());
                writer.write(",");
                writer.write(String.valueOf(data.getList().get(i).getNumberNights()));
                writer.write(",");
                writer.write(String.valueOf(data.getList().get(i).getRoomsNum()));
                writer.write(",");
                writer.write(data.getList().get(i).getRoomType());
                writer.write(",");
                writer.write(String.valueOf(data.getList().get(i).getAdults()));
                writer.write(",");
                writer.write(String.valueOf(data.getList().get(i).getChildren()));
                writer.write(",");
                if(data.getList().get(i).isBreakfast()){
                    writer.write("True");
                }else{
                    writer.write("False");
                }
                writer.write(",");
                writer.write(String.valueOf(data.getList().get(i).getDeposit()));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /*
    Writes out checkin.csv file in comma separated format.
    */
    public void writeCheckIns(Hotels hot, CheckInOut checkin){
        try{
            FileWriter writer = new FileWriter("/Users/mrigankmittal/Desktop/files/checkin.csv");
            writer.write("Reservation Number");
            writer.write(",");
            writer.write("Name");
            writer.write(",");
            writer.write("Date From");
            writer.write(",");
            writer.write("Date To");
            writer.write(",");
            writer.write("Number of Nights");
            writer.write(",");
            writer.write("Number of Rooms");
            writer.write(",");
            writer.write("Room Type");
            writer.write(",");
            writer.write("Number of Adults");
            writer.write(",");
            writer.write("Number of Children");
            writer.write(",");
            writer.write("Breakfast");
            writer.write(",");
            writer.write("Deposit");
            writer.write("\n");
            for(int i = 0; i < checkin.getCheckedIn().size(); i++){
                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getNumber()));
                writer.write(",");
                writer.write(checkin.getCheckedIn().get(i).getName());
                writer.write(",");
                writer.write(checkin.getCheckedIn().get(i).getDateF());
                writer.write(",");
                writer.write(checkin.getCheckedIn().get(i).getDateT());
                writer.write(",");
                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getNumberNights()));
                writer.write(",");
                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getRoomsNum()));
                writer.write(",");
                writer.write(checkin.getCheckedIn().get(i).getRoomType());
                writer.write(",");
                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getAdults()));
                writer.write(",");
                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getChildren()));
                writer.write(",");
                if(checkin.getCheckedIn().get(i).isBreakfast()){
                    writer.write("True");
                }else{
                    writer.write("False");
                }
                writer.write(",");
                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getDeposit()));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /*
    Writes out checkout.csv file in comma separated format.
    */
    public void writeCheckOuts(Hotels hot, CheckInOut checkout){
        try{
            FileWriter writer = new FileWriter("/Users/mrigankmittal/Desktop/files/checkout.csv");
            writer.write("Reservation Number");
            writer.write(",");
            writer.write("Name");
            writer.write(",");
            writer.write("Date From");
            writer.write(",");
            writer.write("Date To");
            writer.write(",");
            writer.write("Number of Nights");
            writer.write(",");
            writer.write("Number of Rooms");
            writer.write(",");
            writer.write("Room Type");
            writer.write(",");
            writer.write("Number of Adults");
            writer.write(",");
            writer.write("Number of Children");
            writer.write(",");
            writer.write("Breakfast");
            writer.write(",");
            writer.write("Deposit");
            writer.write("\n");
            for(int i = 0; i < checkout.getCheckedOut().size(); i++){
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getNumber()));
                writer.write(",");
                writer.write(checkout.getCheckedOut().get(i).getName());
                writer.write(",");
                writer.write(checkout.getCheckedOut().get(i).getDateF());
                writer.write(",");
                writer.write(checkout.getCheckedOut().get(i).getDateT());
                writer.write(",");
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getNumberNights()));
                writer.write(",");
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getRoomsNum()));
                writer.write(",");
                writer.write(checkout.getCheckedOut().get(i).getRoomType());
                writer.write(",");
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getAdults()));
                writer.write(",");
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getChildren()));
                writer.write(",");
                if(checkout.getCheckedOut().get(i).isBreakfast()){
                    writer.write("True");
                }else{
                    writer.write("False");
                }
                writer.write(",");
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getDeposit()));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /*
    Writes out cancellations.csv file in comma separated format.
    */
    public void writeCancellations(Hotels hot, CheckInOut cancellations){
        try{
            FileWriter writer = new FileWriter("/Users/mrigankmittal/Desktop/files/cancellations.csv");
            writer.write("Reservation Number");
            writer.write(",");
            writer.write("Name");
            writer.write(",");
            writer.write("Date From");
            writer.write(",");
            writer.write("Date To");
            writer.write(",");
            writer.write("Number of Nights");
            writer.write(",");
            writer.write("Number of Rooms");
            writer.write(",");
            writer.write("Room Type");
            writer.write(",");
            writer.write("Number of Adults");
            writer.write(",");
            writer.write("Number of Children");
            writer.write(",");
            writer.write("Breakfast");
            writer.write(",");
            writer.write("Deposit");
            writer.write("\n");
            for(int i = 0; i < cancellations.getCancellations().size(); i++){
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getNumber()));
                writer.write(",");
                writer.write(cancellations.getCancellations().get(i).getName());
                writer.write(",");
                writer.write(cancellations.getCancellations().get(i).getDateF());
                writer.write(",");
                writer.write(cancellations.getCancellations().get(i).getDateT());
                writer.write(",");
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getNumberNights()));
                writer.write(",");
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getRoomsNum()));
                writer.write(",");
                writer.write(cancellations.getCancellations().get(i).getRoomType());
                writer.write(",");
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getAdults()));
                writer.write(",");
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getChildren()));
                writer.write(",");
                if(cancellations.getCancellations().get(i).isBreakfast()){
                    writer.write("True");
                }else{
                    writer.write("False");
                }
                writer.write(",");
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getDeposit()));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /*
    Prints out the information contained in the hotels.csv file. The user can then choose from this info.
    */
    public void printInfo(){
        for(int i = 0; i < info.length; i++){
            for(int j = 0; j < info[i].length; j++){
                System.out.print(info[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}