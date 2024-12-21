package menu;

import common.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

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

    public MenuItem selectMenuItem(List<Menu> menuList) {
        MenuItem menuItem = new MenuItem();

        Menu menu = selectMenu(menuList);
        int quantity = insertQuantity();

        menuItem.addMenu(menu, quantity);
        return menuItem;
    }

    private int insertQuantity() {
        int quantity = 0;
        Scanner sc = null;
        while(true) {
            System.out.println("quantity ?");
            sc = new Scanner(System.in);
            String strNum = sc.next();
            if(strNum == null || strNum.equals("") || !StringUtils.isNumeric(strNum)){
                System.out.println("quantity insert error");
                continue;
            }
            quantity = Integer.parseInt(strNum);
            if(quantity == 0) {
                System.out.println("quantity insert error");
                continue;
            }else{
                break;
            }
        }
        return quantity;
    }

    private Menu selectMenu(List<Menu> menuList) {
        Menu menu = null;
        Scanner sc = null;
        while(true) {
            System.out.println("select menu by number or name");
            for (int i = 0; i < menuList.size(); i++) {
                Menu selectedMenu = menuList.get(i);
                System.out.println(String.valueOf(i + 1) + " " + selectedMenu.getName() + " " + selectedMenu.getPrice());
            }

            // 1. menu choice
            sc = new Scanner(System.in);
            String select = sc.next();
            if (select == null || select.equals("")) {
                System.out.println("select menu error");
                continue;
            }

            if(StringUtils.isNumeric(select)){
                Menu selectMenu = menuList.get(Integer.parseInt(select)-1);
                menu = new Menu(selectMenu.getName(), selectMenu.getPrice());
            }else{
                select = select.toLowerCase();
                for(int i = 0; i < menuList.size(); i++) {
                    Menu selectMenu = menuList.get(i);
                    if(selectMenu.getName().toLowerCase().equals(select) ||
                            selectMenu.getName().toLowerCase().startsWith(select)){
                        menu = new Menu(selectMenu.getName(), selectMenu.getPrice());
                        break;
                    }
                }
            }

            if(menu == null) {
                System.out.println("select menu error");
                continue;
            }else{
                break;
            }
        }
        return menu;
    }

}
