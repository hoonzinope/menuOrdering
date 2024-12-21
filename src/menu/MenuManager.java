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
}
