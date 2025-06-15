package emailsearchengine;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        DynamicHashTable table = new DynamicHashTable();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Email Hash Search Engine");
        System.out.println("=========================");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Insert email manually");
            System.out.println("2. Insert emails from file (emails.txt)");
            System.out.println("3. Search for an email");
            System.out.println("4. Delete an email");
            System.out.println("5. Print all emails");
            System.out.println("6. Export all emails to file (exported_emails.txt)");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    table.insert(email);
                    break;
                case 2:
                    try (BufferedReader reader = new BufferedReader(new FileReader("emails.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            table.insert(line.trim());
                        }
                        System.out.println("Emails loaded from file.");
                    } catch (IOException e) {
                        System.out.println("File not found or error reading.");
                    }
                    break;
                case 3:
                    System.out.print("Enter email to search: ");
                    String searchEmail = scanner.nextLine();
                    System.out.println(searchEmail + ": " + (table.search(searchEmail) ? "Found" : "Not Found"));
                    break;
                case 4:
                    System.out.print("Enter email to delete: ");
                    String deleteEmail = scanner.nextLine();
                    boolean removed = table.delete(deleteEmail);
                    System.out.println(removed ? "Deleted successfully." : "Email not found.");
                    break;
                case 5:
                    table.printAll();
                    break;
                case 6:
                    table.exportToFile("emails.txt");
                    System.out.println("Exported to emails.txt");
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
