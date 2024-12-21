package order;

import common.StringUtils;
import discount.DiscountPolicy;
import menu.MenuItem;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private String orderName;
    private List<MenuItem> itemList;
    private LocalDateTime orderDateTime;

    private DiscountPolicy discountPolicy;

    public Order(){
        this.itemList = new ArrayList<>();
        this.orderName = this.createRandomOrderName();
        this.orderDateTime = LocalDateTime.now();
    }

    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public void addItem(MenuItem menuItem) {
        this.itemList.add(menuItem);
    }

    public String currentOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("order ["+orderName+"]\n");
        for(int i = 0; i < itemList.size(); i++) {
            MenuItem menuItem = itemList.get(i);
            sb.append((i+1)+" -- "+menuItem+"\n");
        }
        sb.append("total price = "+this.getTotalPrice()+"\n");
        sb.append("order date "+this.orderDateTime+"\n");
        return sb.toString();
    }

    public void isCancelMenuItem() {
        System.out.println("if cancel order ? Y/N");
        Scanner sc = new Scanner(System.in);
        if(sc.next().equals("Y"))
            this.cancelMenu();
    }

    private void cancelMenu() {
        int cancelNum = 0;
        while(true) {
            System.out.println("insert cancel menu number");
            Scanner sc = new Scanner(System.in);
            String strNum = sc.next();
            if(strNum == null || strNum.equals("") || !StringUtils.isNumeric(strNum)){
                System.out.println("cancel menu number error");
                continue;
            }
            cancelNum = Integer.parseInt(strNum) - 1;
            if(0 <= cancelNum || cancelNum < this.itemList.size()){
                this.itemList.remove(cancelNum);
                break;
            }else{
                System.out.println("cancel menu number over/under flow error");
                continue;
            }
        }
        System.out.println("menu item remove success");
    }

    private int getTotalPrice() {
        int totalPrice = 0;
        for(MenuItem menuItem : this.itemList) {
            totalPrice += menuItem.getPrice();
        }
        return discountPolicy.applyPolicy(totalPrice);
    }

    private String createRandomOrderName(){
        return StringUtils.getRandomString(10);
    }
}
