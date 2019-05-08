
import java.util.List;

public class Main {
    private void printShoppintReceipt(String input) {
        InputParser ip = new InputParser(input);
        List<Item> itemList = ip.getItems();
        String location = ip.getLocation();
        SalesTax.Tax taxLocation = SalesTax.Tax.valueOf(location);
        double subTotal = 0.0;
        double tax = 0.0;
        double total = 0.0;
        System.out.printf("%-15s%15s%15s", "item", "price", "qty");
        for (Item item : itemList) {
            System.out.println();
            String product = item.getProduct().getName();
            int quantity = item.getQuantity();
            double price = item.getPrice();
            subTotal += price;
            tax += Math.round(quantity * price * taxLocation.getTaxRate());
            total += tax + subTotal;
            System.out.printf("%-15s%15.2f%15d", product, price, quantity);
        }
        System.out.println();
        System.out.printf("%-15s%15s%15.2f", "subtotal:", "", subTotal);
        System.out.println();
        System.out.printf("%-15s%15s%15.2f", "tax:", "", tax);
        System.out.println();
        System.out.printf("%-15s%15s%15.2f", "total:", "", total);
        System.out.println();
    }

    public static void main(String[] args) {
        Main main = new Main();
        String input = " Location: CA, 1 book at 17.99, 1 potato chips at 3.99";
        main.printShoppintReceipt(input);
        input = "  Location: NY, 1 book at 17.99, 3 pencils at 2.99";
        main.printShoppintReceipt(input);
        input = " Location: NY, 2 pencils at 2.99, 1 shirt at 29.99";
        main.printShoppintReceipt(input);
    }

}
