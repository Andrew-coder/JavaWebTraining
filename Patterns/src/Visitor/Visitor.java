package Visitor;

/**
 * Created by andri on 11/15/2016.
 */
public interface Element {
    void accept();
}

public interface Visitor {
    void visit(EngineElemet elemet);
    void visit(BodyElement element);
}

public class EngineElemet implements Element {
    @Override
    public void accept() {

    }
}

public class BodyElement implements Element {
    @Override
    public void accept() {

    }
}

public class HooliganVisitor implements Visitor {
    @Override
    public void visit(EngineElemet elemet) {
        System.out.println("start the engine");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("knock the hood");
    }
}

public class MechanicVisitor implements Visitor {
    @Override
    public void visit(EngineElemet elemet) {
        System.out.println("fix the engine of a car");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("polish the body");
    }
}

class Main {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElemet();
        Visitor visitor = new HooliganVisitor();
        body.accept();
        engine.accept();
    }
}
