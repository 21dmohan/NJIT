import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

public class Main {
    //replace with file path
    private static final String FILE_PATH = "C:\\PATH\\NJIT\\src\\supermarket_test.csv";

    public static void main(String args[]) {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            Map<String, Double> customers = new HashMap<String, Double>();
            String[] transactions;

            transactions = scanner.nextLine().split(","); //disregard first line
            while(scanner.hasNextLine()) {
                transactions = scanner.nextLine().split(",");
                if (customers.get(transactions[4]) == null) {
                    customers.put(transactions[4],
                            Double.parseDouble(transactions[5]) *
                            Double.parseDouble(transactions[6]));
                } else {
                    customers.put(transactions[4],
                            customers.get(transactions[4]) +
                                    Double.parseDouble(transactions[5]) *
                                    Double.parseDouble(transactions[6]));
                }
            }

            for (String c : customers.keySet()) {
                System.out.println(c + " " + customers.get(c));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
