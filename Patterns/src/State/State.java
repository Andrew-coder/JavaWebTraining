package State;


/**
 * Created by andri on 11/16/2016.
 */
public interface Activity {
    void doSomething(Human human);
}

public class Human {
    Activity state;
    public void setState(Activity state){
        this.state = state;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}

public class Work implements Activity {
    @Override
    public void doSomething(Human human) {
        System.out.println("work hard...");
        human.setState(new WeekEnd());
    }
}

public class WeekEnd implements Activity {
    @Override
    public void doSomething(Human human) {
        System.out.println("rest zzz");
        human.setState(new Work());
    }
}

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.setState(new Work());
        for(int i=0;i<10;++i) {
            human.doSomething();
        }
    }
}