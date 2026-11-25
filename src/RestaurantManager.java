
import java.util.ArrayList;

public class RestaurantManager {

    private ArrayList<MenuItem> menu = new ArrayList<>();
    private ArrayList<OrderItem> orders = new ArrayList<>();
    private boolean[] tables = new boolean[10];

    // Pre-loaded default menu
    public RestaurantManager() {
        menu.add(new MenuItem(101, "Paneer Butter Masala", "Main Course", 220.00));
        menu.add(new MenuItem(102, "Dal Makhani", "Main Course", 180.00));
        menu.add(new MenuItem(103, "Butter Naan", "Breads", 40.00));
        menu.add(new MenuItem(104, "Veg Biryani", "Rice", 190.00));
        menu.add(new MenuItem(105, "Veg Spring Rolls", "Starters", 120.00));
        menu.add(new MenuItem(106, "Chilli Paneer", "Starters", 170.00));
        menu.add(new MenuItem(107, "Masala Dosa", "South Indian", 110.00));
        menu.add(new MenuItem(108, "Gulab Jamun", "Dessert", 60.00));
        menu.add(new MenuItem(109, "Cold Coffee", "Beverages", 90.00));
        menu.add(new MenuItem(110, "Masala Chai", "Beverages", 30.00));
    }

    public void addItem(MenuItem item) {
        menu.add(item);
        System.out.println("Item added successfully!");
    }

    public void displayMenu() {
        System.out.println("\n========== RESTAURANT MENU ==========");
        System.out.printf("%-8s %-20s %-15s %s%n",
                "ID", "Name", "Category", "Price");

        for (MenuItem item : menu) {
            item.displayItem();
        }
    }

    public MenuItem searchItem(int id) {
        for (MenuItem item : menu) {
            if (item.getItemId() == id) {
                return item;
            }
        }
        return null;
    }

    public void displayTables() {
        System.out.println("\n========== TABLE STATUS ==========");

        for (int i = 0; i < tables.length; i++) {
            System.out.println("Table " + (i + 1) + " : " +
                    (tables[i] ? "Occupied" : "Available"));
        }
    }

    public void assignTable(int id) {
        if (id < 1 || id > 10) {
            System.out.println("Invalid table number!");
        } else if (tables[id - 1]) {
            System.out.println("Table already occupied!");
        } else {
            tables[id - 1] = true;
            System.out.println("Table assigned successfully!");
        }
    }

    public void freeTable(int id) {
        if (id < 1 || id > 10) {
            System.out.println("Invalid table number!");
        } else if (!tables[id - 1]) {
            System.out.println("Table is already available!");
        } else {
            tables[id - 1] = false;
            System.out.println("Table freed successfully!");
        }
    }

    public void addOrder(int itemId, int quantity) {
        MenuItem item = searchItem(itemId);

        if (item == null) {
            System.out.println("Food item not found!");
        } else if (quantity <= 0) {
            System.out.println("Invalid quantity!");
        } else {
            orders.add(new OrderItem(item, quantity));
            System.out.println("Order added successfully!");
        }
    }

    public void displayOrders() {
        double total = 0;

        System.out.println("\n========== ORDER DETAILS ==========");
        System.out.printf("%-20s %-10s %s%n",
                "Food Item", "Quantity", "Amount");

        for (OrderItem order : orders) {
            order.displayOrderItem();
            total += order.getTotal();
        }

        System.out.println("-----------------------------------");
        System.out.printf("Total Amount: Rs. %.2f%n", total);
    }

    public double getOrderTotal() {
        double total = 0;

        for (OrderItem order : orders) {
            total += order.getTotal();
        }

        return total;
    }

    public double calculateGST() {
        return getOrderTotal() * 0.05;
    }

    public void generateBill() {
        double subtotal = getOrderTotal();

        if (subtotal == 0) {
            System.out.println("No orders available!");
            return;
        }

        double gst = calculateGST();
        double finalAmount = subtotal + gst;

        System.out.println("\n========== CUSTOMER BILL ==========");
        System.out.printf("Subtotal      : Rs. %.2f%n", subtotal);
        System.out.printf("GST (5%%)      : Rs. %.2f%n", gst);
        System.out.println("-----------------------------------");
        System.out.printf("Final Amount  : Rs. %.2f%n", finalAmount);
        System.out.println("===================================");
    }

    public void generateReports() {
        int totalMenuItems = menu.size();
        int totalOrders = orders.size();
        int occupiedTables = 0;

        for (boolean table : tables) {
            if (table) {
                occupiedTables++;
            }
        }

        int availableTables = tables.length - occupiedTables;
        double totalSales = getOrderTotal();

        System.out.println("\n========== RESTAURANT REPORT ==========");

        System.out.println("Total Menu Items   : " + totalMenuItems);
        System.out.println("Total Order Entries: " + totalOrders);
        System.out.println("Total Tables       : " + tables.length);
        System.out.println("Occupied Tables    : " + occupiedTables);
        System.out.println("Available Tables   : " + availableTables);

        System.out.println("---------------------------------------");

        System.out.printf("Total Sales        : Rs. %.2f%n", totalSales);

        System.out.println("=======================================");
    }
}
