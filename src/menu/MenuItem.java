package menu;

import java.time.LocalDateTime;

public class MenuItem {
    private Menu selectedMenu;
    private int quantity;
    private LocalDateTime selectedDateTime;

    public void addMenu(Menu menu, int quantity) {
        this.selectedMenu = menu;
        this.quantity = quantity;
        this.selectedDateTime = LocalDateTime.now();
    }

    public int getPrice() {
        return this.selectedMenu.getPrice() * this.quantity;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "selectedMenu=" + selectedMenu +
                ", quantity=" + quantity +
                ", selectedDateTime=" + selectedDateTime +
                '}';
    }
}
