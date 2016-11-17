interface Product {
    void productMethod();
}

class ConcreteProduct implements Product {
    @Override
    public void productMethod() {

    }
}

interface Creator {
    Product factoryMethod();
}

class ConcreteCreator implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

class Main {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.factoryMethod();
    }
}

