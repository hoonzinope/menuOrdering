package menu;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    private static MenuManager instance;
    private MenuManager(){
    }

    public static MenuManager getInstance(){
        if(instance == null)
            instance = new MenuManager();
        return instance;
    }

    public List<Menu> showMenuList() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("Americano", 3000));
        menuList.add(new Menu("Latte", 4000));
        menuList.add(new Menu("Milk tea", 4000));
        return menuList;
    }

    public void selectMenu() {
        System.out.println("select menu by number or name");
        List<Menu> menuList = this.showMenuList();
        for(int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);
            String name = menu.getName();
            int price = menu.getPrice();
            System.out.println(String.valueOf(i+1) + " " + name + " / " + price);
        }
    }

}
