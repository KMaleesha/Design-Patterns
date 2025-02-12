package Factory;

public class Restaurant {
    public static void main(String[] args) {
        Burger burger = BurgerFactory.createBurger("chicken");
        System.out.println(burger);
        Burger burger2 = BurgerFactory.createBurger("Beef");
        System.out.println(burger2);
    }
}

interface Burger{
    void order();
}

class ChickenBurger implements Burger{
    @Override
    public void order() {
        System.out.println("Chicken Burger");
    }
}

class BeefBurger implements Burger{
    @Override
    public void order() {
        System.out.println("Beef Burger");
    }
}

class BurgerFactory{
    public static Burger createBurger(String type){
        if (type.equalsIgnoreCase("chicken")){
            return new ChickenBurger();
        }else if (type.equalsIgnoreCase("beef")){
            return new BeefBurger();
        }
        return null;
    }
}
