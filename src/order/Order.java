package order;

import menu.MenuItem;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private String orderName;
    private List<MenuItem> itemList;
    private LocalDateTime orderDateTime;

    public Order(){
        this.itemList = new ArrayList<>();
        this.orderName = this.createRandomOrderName();
        this.orderDateTime = LocalDateTime.now();
    }

    public void addItem(MenuItem menuItem) {
        this.itemList.add(menuItem);
    }

    public String currentOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("order ["+orderName+"]\n");
        for(MenuItem menuItem : itemList) {
            sb.append("-- "+menuItem+"\n");
        }
        sb.append("total price = "+this.getTotalPrice()+"\n");
        sb.append("order date "+this.orderDateTime+"\n");
        return sb.toString();
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for(MenuItem menuItem : this.itemList) {
            totalPrice += menuItem.getPrice();
        }
        return totalPrice;
    }

    private String createRandomOrderName(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        // a = 97 / A = 65;
        for(int i = 0; i < 10; i++){
            int UL = random.nextInt(3);
            if(UL == 1) UL = 97;
            else if(UL == 2)UL = 65;
            else UL = 0;

            int r = random.nextInt(26);
            int n = random.nextInt(10);
            if(UL == 0)
                stringBuilder.append(UL+n);
            else
                stringBuilder.append((char)(UL+r));
        }
        return stringBuilder.toString();
    }
}
