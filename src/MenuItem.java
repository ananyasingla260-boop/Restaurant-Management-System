
public class MenuItem {

    private int itemId;
    private String itemName;
    private String category;
    private double price;

    public MenuItem(int itemId, String itemName, String category, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void displayItem() {
        System.out.printf("%-8d %-20s %-15s Rs. %.2f%n",
                itemId, itemName, category, price);
    }
}

