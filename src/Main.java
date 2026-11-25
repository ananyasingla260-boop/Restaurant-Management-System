
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static RestaurantManager manager = new RestaurantManager();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("       RESTAURANT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Menu Management");
            System.out.println("2. Table Assignment");
            System.out.println("3. Order Management");
            System.out.println("4. Billing");
            System.out.println("5. Reports");
            System.out.println("6. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    menuManagement();
                    break;

                case 2:
                    tableManagement();
                    break;

                case 3:
                    orderManagement();
                    break;

                case 4:
                    manager.generateBill();
                    break;

                case 5:
                    manager.generateReports();
                    break;

                case 6:
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    public static void menuManagement() {

        int choice;

        do {
            System.out.println("\n========== MENU MANAGEMENT ==========");
            System.out.println("1. Add Food Item");
            System.out.println("2. Display Menu");
            System.out.println("3. Search Food Item");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    manager.addItem(
                            new MenuItem(id, name, category, price)
                    );
                    break;

                case 2:
                    manager.displayMenu();
                    break;

                case 3:
                    System.out.print("Enter Item ID: ");
                    int searchId = sc.nextInt();

                    MenuItem item = manager.searchItem(searchId);

                    if (item != null) {
                        item.displayItem();
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    public static void tableManagement() {

        int choice;

        do {
            System.out.println("\n========== TABLE ASSIGNMENT ==========");
            System.out.println("1. View Tables");
            System.out.println("2. Assign Table");
            System.out.println("3. Free Table");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    manager.displayTables();
                    break;

                case 2:
                    System.out.print("Enter Table Number (1-10): ");
                    int tableId = sc.nextInt();

                    manager.assignTable(tableId);
                    break;

                case 3:
                    System.out.print("Enter Table Number: ");
                    int freeId = sc.nextInt();

                    manager.freeTable(freeId);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    public static void orderManagement() {

        int choice;

        do {
            System.out.println("\n========== ORDER MANAGEMENT ==========");
            System.out.println("1. Display Menu");
            System.out.println("2. Add Order");
            System.out.println("3. View Orders");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    manager.displayMenu();
                    break;

                case 2:
                    System.out.print("Enter Food Item ID: ");
                    int itemId = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    manager.addOrder(itemId, quantity);
                    break;

                case 3:
                    manager.displayOrders();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}
