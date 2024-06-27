public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        FileIO.readCSV("src/sample.csv", inventory);
    }
}
