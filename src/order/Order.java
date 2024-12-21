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

    public void cancelMenu(int menu_index) throws IllegalArgumentException{
        if(0 <= menu_index && menu_index < this.itemList.size())
            this.itemList.remove(menu_index);
        else
            throw new IllegalArgumentException("remove failed. check menu index");
    }

    public int getTotalPrice() {
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
