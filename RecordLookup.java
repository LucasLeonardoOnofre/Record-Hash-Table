import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * A class that acts as the entry point into the program and takes in user input
 * so they can look at the data loaded in the program.
 *
 */
public class RecordLookup {
    /**
     * Entry point of the program allowing the user to interact with the bst.
     * 
     * @param args Cmd inputs on program execution.
     */
    public static void main(String[] args) {
        boolean running = true;
        RecordHashTable table = new RecordHashTable();
        table = readFile("records.csv");
        Scanner scanner = new Scanner(System.in);
        while (running) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Input given was out of range.");
                        break;
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("Invalid input was found, please give a valid integer input.");
            }

        }
        scanner.close();
    }

    // /**
    // * This method reads a csv file and gets the Record data out of it and adds it
    // to the bst.
    // * @param filepath the filepath for the file that needs to be read.
    // * @return the filled bst based on the info given in the file.
    // */
    public static RecordHashTable readFile(String filepath) {
        RecordHashTable table = new RecordHashTable();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            String[] split;

            br.readLine();

            while ((line = br.readLine()) != null) {

                split = line.split(",");

                table.put(new Record(split[0], Integer.parseInt(split[1]),
                        split[2], split[3]));
            }

            br.close();

        } catch (Exception ex) {

            System.out.println(
                    "File not found! \nPlease place Record.csv in the same directory as the program. \nOtherwise the table will be empty!\n");
        }

        return table;
    }
}