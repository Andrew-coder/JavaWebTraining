package Prototype;

/**
 * Created by andri on 11/15/2016.
 */
public interface Copyable {
    Object copy();
}

public class Human implements Copyable {
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        return new Human(age, name);
    }
}

public class HumanFactory{
    private Human human;

    public HumanFactory(Human human) {
        setPrototype(human);
    }

    public void setPrototype(Human human) {
        this.human = human;
    }

    public Human makeCopy() {
        return (Human)human.copy();
    }
}

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human(21,"Andrew");
        HumanFactory factory = new HumanFactory(human1);
        Human human2 = factory.makeCopy();
    }
}
