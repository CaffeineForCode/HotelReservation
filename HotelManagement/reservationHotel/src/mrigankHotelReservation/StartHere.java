package mrigankHotelReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by IntelliJ IDEA.
 * User:mrigankmittal
 * Date:6/6/16
 * Time:9:13 PM
 * Project:reservationHotel
 */


public class StartHere {
    private ReadInData read = new ReadInData();
    private ReservationData data;
    private CheckInOut checkData;

    public static void main(String[] args) throws Exception {
        StartHere startHere = new StartHere();
        Hotels hot = new Hotels(startHere.getRead().readHotelFile());

        ReservationData data = new ReservationData(startHere.getRead().readResFile(), hot);
        startHere.setData(data);

        CheckInOut checkData = new CheckInOut(startHere.getRead().checkInFile(), startHere.getRead().checkOutFile(), startHere.getRead().cancellationsFile(), hot);
        startHere.setCheckData(checkData);
        Menu mainMenu = new Menu();
        mainMenu.menu(hot, startHere);
    }


    /*
    Creates a new reservation.
    */
    public Reservation createRes(Hotels hot, String name, String dateFrom, int nightsNum, int roomsNum, String roomType, int adults, int children, boolean breakfast, double deposit){
        Reservation newRes = new Reservation(name, dateFrom, nightsNum, roomsNum, roomType, adults, children, breakfast, deposit);
        return newRes;
    }

    /*
    If the room is available add it to the Reservation list. And then write the Reservation to the res.csv file.
    */
    public boolean addToList(Reservation newRes, Hotels hot){
        if(data.checkAvailability(newRes, hot, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomType())){
            data.getList().add(newRes);
            if(newRes.getRoomsNum() > 1){
                for(int i = 1; i < newRes.getRoomsNum(); i++){
                    if(data.checkAvailability(newRes, hot, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomType())){

                    }else{
                        data.findRoom(newRes.getNumber(), hot);
                        return false;
                    }
                }
                read.writeReservation(hot, data);
                return true;
            }else if(newRes.getRoomsNum() == 1){
                read.writeReservation(hot, data);
                return true;
            }
        }else{
            return false;
        }
        return false;
    }

    /*
    If the room is available return true.
    */
    public boolean checkRoomNoWrite(Reservation newRes, Hotels hot){
        if(data.checkAvailability(newRes, hot, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomType())){
            data.getList().add(newRes);
            if(newRes.getRoomsNum() > 1){
                for(int i = 1; i < newRes.getRoomsNum(); i++){
                    if(data.checkAvailability(newRes, hot, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomType())){
                    }else{
                        data.findRoom(newRes.getNumber(), hot);
                        return false;
                    }
                }
                return true;
            }else if(newRes.getRoomsNum() == 1){
                return true;
            }
        }else{
            return false;
        }
        return false;
    }


    /*
    Return the total cost of the passed in Reservation Object
    */
    public double getTotalCost(Reservation newRes, Hotels hot){
        int start = newRes.getDateFrom().get(Calendar.DAY_OF_WEEK);
        if(start == 1){
            start = 6;
        }else{
            start = start - 2;
        }
        int numDays = newRes.getNumberNights();
        double[] rates = data.getRates(newRes, hot);
        double totalCost = 0;
        if(numDays == 1){
            totalCost = rates[start];
        }else{
            while(numDays > 0){
                while(start < rates.length){
                    totalCost = totalCost + rates[start];
                    start++;
                    numDays--;
                    if(numDays == 0){
                        break;
                    }
                }
                start = 0;
            }
        }
        int numRooms = newRes.getRoomsNum();
        totalCost = totalCost * numRooms;

        return totalCost;
    }

    public boolean isValidDate(String inDate) {

        if (inDate == null){
            System.out.println("Date is null");
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (inDate.trim().length() != dateFormat.toPattern().length()){
            System.out.println("Wrong format");
            return false;
        }

        dateFormat.setLenient(false);

        try{
            //parse the inDate parameter
            dateFormat.parse(inDate.trim());
        }
        catch (ParseException pe) {
            System.out.println("Invalid Date");
            return false;

        }
        return true;
    }

    public boolean isDateInFuture(String date){
        if(isValidDate(date)){
            GregorianCalendar today = new GregorianCalendar();
            String[] f = date.split("/");
            int d = Integer.parseInt(f[0]);
            int m = Integer.parseInt(f[1]) - 1;
            int y = Integer.parseInt(f[2]);
            GregorianCalendar future =  new GregorianCalendar(y, m, d);
            if(future.getTimeInMillis() > today.getTimeInMillis()){
                return true;
            }
            System.out.println("Date not in future");
        }
        return false;
    }


    public ReadInData getRead() {
        return read;
    }

    public ReservationData getData() {
        return data;
    }

	/*public CheckInOut getCheckData() {
		return checkData;
	}*/

    public void setData(ReservationData data) {
        this.data = data;
    }

    public void setCheckData(CheckInOut checkData) {
        this.checkData = checkData;
    }


    public CheckInOut getCheckData() {

        return checkData;
    }
}