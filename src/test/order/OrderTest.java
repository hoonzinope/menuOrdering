package order;

import discount.DiscountPolicy;
import discount.FixedPriceDiscountPolicy;
import discount.NoDiscountPolicy;
import discount.PercentDiscountPolicy;
import menu.Menu;
import menu.MenuItem;
import menu.MenuManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {
    @Test
    public void initTest() {
        System.out.println("init test");
    }

    List<MenuItem> menuItemList = new ArrayList<>();
    @BeforeEach
    public void setting() {
        menuItemList = new ArrayList<>();

        Menu menu1 = new Menu("test",1000);
        MenuItem menuItem1 = new MenuItem();
        menuItem1.addMenu(menu1, 1);

        Menu menu2 = new Menu("test2", 2000);
        MenuItem menuItem2 = new MenuItem();
        menuItem2.addMenu(menu2, 1);

        menuItemList.add(menuItem1);
        menuItemList.add(menuItem2);
    }

    @Test
    public void displayCurrentOrderTest() {
        // given -> beforeEach

        // when
        Order order = new Order();
        order.setDiscountPolicy(new NoDiscountPolicy());
        order.addItem(menuItemList.get(0));
        order.addItem(menuItemList.get(1));

        // then
        System.out.println(order.currentOrder());
    }

    @Test
    public void fixedDiscountPolicyTest() {
        // when
        Order order = new Order();
        order.setDiscountPolicy(new FixedPriceDiscountPolicy(1000));
        order.addItem(menuItemList.get(0));
        order.addItem(menuItemList.get(1));

        // then
        assertEquals(2000, order.getTotalPrice());
    }

    @Test
    public void percentDiscountPolicyTest() {
        // when
        Order order = new Order();
        order.setDiscountPolicy(new PercentDiscountPolicy(10));
        order.addItem(menuItemList.get(0));
        order.addItem(menuItemList.get(1));

        // then
        assertEquals(2700, order.getTotalPrice());
    }

    @Test
    public void percentExceptionTest() {
        // when & then
        assertThrows(
            IllegalArgumentException.class,
                () ->{
                    Order order = new Order();
                    order.setDiscountPolicy(new PercentDiscountPolicy(-1));
                }
        );
    }

    @Test
    public void cancelMenuItemTest() {
        // when
        Order order = new Order();
        order.setDiscountPolicy(new NoDiscountPolicy());
        order.addItem(menuItemList.get(0));
        order.addItem(menuItemList.get(1));

        order.cancelMenu(0);

        // then
        assertEquals(2000, order.getTotalPrice());
        System.out.println(order.currentOrder());
    }
}
