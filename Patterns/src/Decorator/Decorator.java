package Decorator;

/**
 * Created by andri on 11/15/2016.
 */
public interface PrinterInterface {
    void print();
}

public class Printer implements PrinterInterface{
    @Override
    public void print() {
        System.out.print("Some text!");
    }
}

public abstract class Decorator implements PrinterInterface {
    PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
    }
}

public class QuotesDecorator extends Decorator {
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.println("\"");
        super.print();
        System.out.println("\"");
    }
}

public class LeftBracketDecorator extends Decorator {
    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.println("[");
        super.print();
    }
}

public class RightBracketDecorator extends Decorator {
    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("]");
    }
}

class Main {
    public static void main(String[] args) {
        PrinterInterface printer = new QuotesDecorator(new LeftBracketDecorator(
                new RightBracketDecorator(new Printer())));
    }
}
