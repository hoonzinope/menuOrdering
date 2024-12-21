package menu;

public class Menu {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
