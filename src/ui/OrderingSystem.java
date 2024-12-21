package ui;

import common.StringUtils;
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
            this.isCancelMenuItem(order);

            // end check
            System.out.println("if exit ? Y / N");
            Scanner sc = new Scanner(System.in);
            if(sc.next().equals("Y")){
                break;
            }
        }
        System.out.println(order.currentOrder());
    }

    private void isCancelMenuItem(Order order) {
        System.out.println("if cancel order ? Y/N");
        Scanner sc = new Scanner(System.in);
        if(sc.next().equals("Y")){
            int cancelNum = 0;
            while(true) {
                System.out.println("insert cancel menu number");
                sc = new Scanner(System.in);
                String strNum = sc.next();
                if(strNum == null || strNum.equals("") || !StringUtils.isNumeric(strNum)){
                    System.out.println("cancel menu number error");
                    continue;
                }
                cancelNum = Integer.parseInt(strNum) - 1;
                try{
                    order.cancelMenu(cancelNum);
                    break;
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                }
            }
            System.out.println("menu item remove success");
        }
    }
}
