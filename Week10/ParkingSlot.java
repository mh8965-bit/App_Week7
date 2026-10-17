public class ParkingSlot {
    public static void main(String[] args) {
        String[] slots = {"S1", "S2", "S3", "S4", "S5"};
        String[] vehicles = {"Car", "Bike", "Car", "Bike", "Car"};
        boolean[] available = {true, false, true, true, false};

        System.out.println("Available car parking slots:");

        for (int i = 0; i < slots.length; i++) {
            if (vehicles[i].equals("Car") && available[i]) {
                System.out.println(slots[i]);
            }
        }
    }
}