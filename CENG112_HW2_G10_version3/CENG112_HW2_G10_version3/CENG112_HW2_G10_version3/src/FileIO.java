import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class FileIO {
        public static ArrayList<Reservation> readFile()  {
        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CENG112_HW2_G10_version3/src/reservations.txt"));
            String line ;
            while((line = reader.readLine())!=null){
                String[] parts = line.split(",");
                Reservation reservation = new Reservation(callReservationID(line),callCustomerName(line),callRoomType(line));
                reservations.add(reservation);
            }
            reader.close();

        }
        catch (Exception E){
            System.out.println(E.getMessage());
        }
        return reservations;
    }
    ////////////////
    public static String callReservationID(String line) {
        return line.split(",")[0];
    }

    public static String callCustomerName(String line) {
        return line.split(",")[1];
    }

    public static String callRoomType(String line) {
        return line.split(",")[2];
    }
    ////////////////////

}




