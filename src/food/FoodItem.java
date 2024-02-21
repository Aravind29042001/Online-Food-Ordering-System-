package food;

import java.util.ArrayList;
import java.util.List;


class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private List<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double getTotalPrice() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public void clearOrder() {
        items.clear();
    }
}

class Restaurant {
    private List<FoodItem> menu = new ArrayList<>();

    public void addToMenu(FoodItem item) {
        menu.add(item);
    }

    public List<FoodItem> getMenu() {
        return menu;
    }
}
