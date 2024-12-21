package ui;

import discount.NoDiscountPolicy;
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
        order.setDiscountPolicy(new NoDiscountPolicy());
        while(true) {
            // select menu & quantity
            MenuItem menuItem = new MenuItem().selectMenuItem(menuList);
            order.addItem(menuItem);

            // 3-1. cancel order
            System.out.println(order.currentOrder());
            order.isCancelMenuItem();

            // end check
            System.out.println("if exit ? Y / N");
            Scanner sc = new Scanner(System.in);
            if(sc.next().equals("Y")){
                break;
            }
        }
        System.out.println(order.currentOrder());
    }
}
