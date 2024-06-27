import java.util.ArrayList;

public class HotelReservation {
    public static void main(String[] args) {
        //creating room stacks
        StackInterface<Room> singleRoomStack = new ArrayStack<Room>();
        StackInterface<Room> doubleRoomStack = new ArrayStack<Room>();
        StackInterface<Room> suiteRoomStack = new ArrayStack<Room>();
        StackInterface<Room> deluxeRoomStack = new ArrayStack<Room>();

        MyArrayList<Room> availableRoom = new MyArrayList<Room>();
        MyArrayList<Room> unavailableRoom = new MyArrayList<Room>();
        // each for loop push the rooms to stack what type of room is and also give number
        System.out.println("Single pile of room (from top to bottom):");
        for (int i = 5; i >= 1; i--) {
            Room singleRoom = new Room(i, "Single", true);
            singleRoomStack.push(singleRoom);
            availableRoom.add(singleRoom);
        }
        singleRoomStack.displayElements();

        System.out.println("Double pile of room (from top to bottom):");
        for (int i = 10; i >= 6; i--) {
            Room doubleRoom = new Room(i, "Double", true);
            doubleRoomStack.push(doubleRoom);
            availableRoom.add(doubleRoom);
        }
        doubleRoomStack.displayElements();

        System.out.println("Suite pile of room (from top to bottom):");
        for (int i = 15; i >= 11; i--) {
            Room suiteRoom = new Room(i, "Suite", true);
            suiteRoomStack.push(suiteRoom);
            availableRoom.add(suiteRoom);
        }
        suiteRoomStack.displayElements();

        System.out.println("Deluxe pile of room (from top to bottom):");
        for (int i = 20; i >= 16; i--) {
            Room deluxeRoom = new Room(i, "Deluxe", true);
            deluxeRoomStack.push(deluxeRoom);
            availableRoom.add(deluxeRoom);
        }
        deluxeRoomStack.displayElements();


        QueueInterface<Reservation> singleReservationQueue = new ArrayQueue<Reservation>();
        QueueInterface<Reservation> doubleReservationQueue = new ArrayQueue<Reservation>();
        QueueInterface<Reservation> suiteReservationQueue = new ArrayQueue<Reservation>();
        QueueInterface<Reservation> deluxeReservationQueue = new ArrayQueue<Reservation>();


        FileIO ourReservations = new FileIO();
        ArrayList<Reservation> listOfReservations = ourReservations.readFile();

        for (int i = 0; i < listOfReservations.size(); i++) {
            Reservation reservation = listOfReservations.get(i);
            if (reservation.getRoomType().equals("Single")) {
                singleReservationQueue.enqueue(reservation);
            } else if (reservation.getRoomType().equals("Double")) {
                doubleReservationQueue.enqueue(reservation);
            } else if (reservation.getRoomType().equals("Suite")) {
                suiteReservationQueue.enqueue(reservation);
            } else if (reservation.getRoomType().equals("Deluxe")) {
                deluxeReservationQueue.enqueue(reservation);
            }
        }




        processReservations(singleRoomStack, singleReservationQueue, unavailableRoom, availableRoom);

        processReservations(doubleRoomStack, doubleReservationQueue, unavailableRoom, availableRoom);

        processReservations(suiteRoomStack, suiteReservationQueue, unavailableRoom, availableRoom);

        processReservations(deluxeRoomStack, deluxeReservationQueue, unavailableRoom, availableRoom);

        System.out.println("*************************");
        singleReservationQueue.displayElements();
        doubleReservationQueue.displayElements();
        suiteReservationQueue.displayElements();
        deluxeReservationQueue.displayElements();
        System.out.println("*************************");
        System.out.println("Unavailable Rooms:\n");
        for (int i=1;i<=unavailableRoom.getLength();i++){
            System.out.println(unavailableRoom.getEntry(i));
        }
        System.out.println("Available Rooms:\n");
        for (int i=1;i<=availableRoom.getLength();i++){
            System.out.println(availableRoom.getEntry(i));
        }

        for(int i = unavailableRoom.getLength(); i>0;i--)
        {
            Room currentRoom = unavailableRoom.getEntry(i);
            if(currentRoom.getRoomNumber()%2==1)
            {
                currentRoom.setAvailability(true);
                unavailableRoom.remove(currentRoom);
                availableRoom.add(currentRoom);
                switch (currentRoom.getRoomType())
                {
                    case "Single" -> singleRoomStack.push(currentRoom);
                    case "Double" -> doubleRoomStack.push(currentRoom);
                    case "Suite" -> suiteRoomStack.push(currentRoom);
                    case "Deluxe" -> deluxeRoomStack.push(currentRoom);
                }

            }


        }



        processReservations(singleRoomStack, singleReservationQueue, unavailableRoom, availableRoom);

        processReservations(doubleRoomStack, doubleReservationQueue, unavailableRoom, availableRoom);

        processReservations(suiteRoomStack, suiteReservationQueue, unavailableRoom, availableRoom);

        processReservations(deluxeRoomStack, deluxeReservationQueue, unavailableRoom, availableRoom);
        System.out.println("*************************");
        singleRoomStack.displayElements();
        doubleRoomStack.displayElements();
        suiteRoomStack.displayElements();
        deluxeRoomStack.displayElements();
        System.out.println("*************************");
        System.out.println("Unavailable Rooms:\n");
        for (int i=1;i<=unavailableRoom.getLength();i++){
            System.out.println(unavailableRoom.getEntry(i));
        }
        System.out.println("Available Rooms:\n");
        for (int i=1;i<=availableRoom.getLength();i++){
            System.out.println(availableRoom.getEntry(i));
        }






    }


    public static void processReservations(StackInterface<Room> roomStack, QueueInterface<Reservation> roomReservationQueue , MyArrayList<Room> unavailableRoom, MyArrayList<Room> availableRoom)
    {
        while (!roomReservationQueue.isEmpty() && !roomStack.isEmpty())
        {
            Reservation reservation = roomReservationQueue.getFront();
            Room room = roomStack.peek();
            if(room.getAvailability())
            {
                roomStack.pop();
                room.setAvailability(false);
                unavailableRoom.add(room);
                availableRoom.remove(room);
                roomReservationQueue.dequeue();
            }

            System.out.println("Assigning room " + room.getRoomNumber() + " to " + reservation.getCustomerName());
        }
    }

}
