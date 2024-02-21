package food;


import java.util.List;
import java.util.Scanner;


public class OnlineFoodOrderingSystem {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Food Ordering System!");
        System.out.println("Please log in to continue.");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (!authenticate(username, password)) {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        System.out.println("Login successful!\n");

        Restaurant restaurant = new Restaurant();
        restaurant.addToMenu(new FoodItem("Burger", 5.99));
        restaurant.addToMenu(new FoodItem("Pizza", 8.99));
        restaurant.addToMenu(new FoodItem("Salad", 4.99));

        Order order = new Order();

        while (true) {
            System.out.println("Menu:");
            List<FoodItem> menu = restaurant.getMenu();
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).getName() + " - $" + menu.get(i).getPrice());
            }
            System.out.println("Enter the number of the item you want to order (0 to finish):");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice < 1 || choice > menu.size()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            order.addItem(menu.get(choice - 1));
        }

        System.out.println("\nYour order:");
        List<FoodItem> orderedItems = order.getItems();
        for (FoodItem item : orderedItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + order.getTotalPrice());

        scanner.close();
    }

    private static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}






