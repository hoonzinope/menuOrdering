package ui;

import menu.Menu;
import menu.MenuItem;
import menu.MenuManager;
import order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderingSystem {

    // 1. menu choice
    // 2. quantity insert
    // 3. current order check
    // 3-1. [optional] cancel menu (menu & quantity)
    // 4. exit check
    public void run() {
        System.out.println("Hello menu ordering system");
        MenuManager menuManager = MenuManager.getInstance();
        List<Menu> menuList = menuManager.showMenuList();

        System.out.println("what do you want?");
        Order order = new Order();
        while(true) {
            Menu menu = null;

            System.out.println("select menu by number or name");
            for (int i = 0; i < menuList.size(); i++) {
                Menu selectedMenu = menuList.get(i);
                System.out.println(String.valueOf(i + 1) + " " + selectedMenu.getName() + " " + selectedMenu.getPrice());
            }

            // 1. menu choice
            Scanner sc = new Scanner(System.in);
            String select = sc.next();
            if (select == null || select.equals("")) {
                System.out.println("select menu error");
                continue;
            }

            if(this.isNumeric(select)){
                Menu selectMenu = menuList.get(Integer.parseInt(select)-1);
                menu = new Menu(selectMenu.getName(), selectMenu.getPrice());
            }else{
                for(int i = 0; i < menuList.size(); i++) {
                    Menu selectMenu = menuList.get(i);
                    if(selectMenu.getName().toLowerCase().equals(select) ||
                            selectMenu.getName().toLowerCase().startsWith(select)){
                        menu = new Menu(selectMenu.getName(), selectMenu.getPrice());
                        break;
                    }
                }
            }

            // 2. quantity insert
            System.out.println("quantity ?");
            sc = new Scanner(System.in);
            String strNum = sc.next();
            if(strNum == null || strNum.equals("") || !this.isNumeric(strNum)){
                System.out.println("quantity insert error");
                continue;
            }
            int quantity = Integer.parseInt(strNum);

            // 3. current order check
            MenuItem menuItem = new MenuItem();
            menuItem.addMenu(menu, quantity);
            order.addItem(menuItem);

            // 3-1. cancel order

            // end check
            System.out.println("if exit ? Y / N");
            sc = new Scanner(System.in);
            if(sc.next().equals("Y")){
                break;
            }
        }
        System.out.println(order.currentOrder());
    }

    private boolean isNumeric(String strNum) {
        try {
            int num = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
