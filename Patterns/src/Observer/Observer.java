package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by andri on 11/15/2016.
 */
public interface Observer {
    void handleEvent();
}

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer Observer);
    void notifyObservers();
}

public class NewsLetter implements Observable{
    int stateVariable;
    List<Observer> observers;

    public NewsLetter() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observers)
            observer.handleEvent();
    }

    public void setStateVariable(int stateVariable) {
        this.stateVariable = stateVariable;
        notifyObservers();
    }
}

public class Subscriber implements Observer {
    @Override
    public void handleEvent() {
        System.out.println("news changed!");
    }
}

class Main {
    public static void main(String[] args) {
        NewsLetter news = new NewsLetter();
        news.addObserver(new Subscriber());
        news.addObserver(new Subscriber());
        news.setStateVariable(10);
    }
}