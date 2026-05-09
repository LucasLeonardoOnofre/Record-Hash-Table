import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class RecordLookup {

    public static void main(String[] args) {

        RecordHashTable table = readFile("records.csv");
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("------Welcome to the Menu ------");
            System.out.println("1. Show number of records");
            System.out.println("2. Print all records");
            System.out.println("3. Search for a record");
            System.out.println("4. Add a record");
            System.out.println("5. Remove a record");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            try {

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.println("Size: " + table.size());
                        break;

                    case 2:
                        table.dump();
                        break;

                    case 3:
                        System.out.print("Enter title: ");
                        String searchTitle = scanner.nextLine();

                        Record found = table.get(searchTitle);

                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Record not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();

                        System.out.print("Enter year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter artist: ");
                        String artist = scanner.nextLine();

                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();

                        table.put(new Record(genre, year, artist, title));

                        System.out.println("Record added.");
                        break;

                    case 5:
                        System.out.print("Enter title to remove: ");
                        String removeTitle = scanner.nextLine();

                        Record temp = table.get(removeTitle);

                        if (temp != null) {
                            table.remove(temp);
                            System.out.println("Record removed.");
                        } else {
                            System.out.println("Record not found.");
                        }
                        break;

                    case 6:
                        running = false;
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                scanner.nextLine();
            }

            System.out.println();
        }

        scanner.close();
    }

    public static RecordHashTable readFile(String filepath) {

        RecordHashTable table = new RecordHashTable();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filepath));

            String line;
            String[] split;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                split = line.split(",");

                table.put(new Record(
                        split[0],
                        Integer.parseInt(split[1]),
                        split[2],
                        split[3]));
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Could not load file. Starting empty table.");
        }

        return table;
    }
}
