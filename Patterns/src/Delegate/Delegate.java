package Delegate;

/**
 * Created by andri on 11/15/2016.
 */

public interface IFood {
    void cook();
}

public class Waiter  {
    IFood food;

    public void setFood(IFood food) {
        this.food = food;
    }

    public void cook() {
        food.cook();
    }
}

public class Cheff implements IFood {
    @Override
    public void cook() {
        System.out.println("cook some dish");
    }
}

public class Cocktailer implements IFood {
    @Override
    public void cook() {
        System.out.println("cock some cocktail");
    }
}

class Main {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.setFood(new Cheff());
        waiter.cook();
        waiter.setFood(new Cocktailer());
        waiter.cook();
    }
}



