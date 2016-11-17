abstract class C{
    void templateMethod() {
        System.out.println("1");
        differ();
        System.out.println("4");
        differ2();
    }
    abstract void differ();
    abstract void differ2();
}

class A extends C {
    @Override
    void differ() {
        System.out.println("2");
    }

    @Override
    void differ2() {
        System.out.println("6");
    }
}

class B extends C {
    @Override
    void differ() {
        System.out.println("3");
    }

    @Override
    void differ2() {}
}