import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    public static void readCSV(String filePath, Inventory inventory) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                switch (values[0]) {
                    case "add":
                        inventory.addProduct(values[1], values[2], Double.parseDouble(values[3]));
                        break;
                    case "search":
                        inventory.searchProduct(values[1]);
                        break;
                    case "list":
                        inventory.listProducts();
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
