public interface Product {
    void productMethod();
}

public class ConcreteProduct implements Product {
    @Override
    public void productMethod() {

    }
}

public interface Creator {
    Product factoryMethod();
}

public class ConcreteCreator implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

public class Main {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.factoryMethod();
    }
}

