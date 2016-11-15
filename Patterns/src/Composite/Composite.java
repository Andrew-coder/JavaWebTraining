package Composite;

import java.util.List;

/**
 * Created by andri on 11/15/2016.
 */

public interface Shape {
    void draw();
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Some circle");
    }
}

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Some square");
    }
}

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Some triangle");
    }
}

public class Composite implements Shape {
    List<Shape> components;
    @Override
    public void draw() {
        for (Shape component: components) {
            component.draw();
        }
    }

    public void addComponent(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }
}

class Main {
    public static void main(String[] args) {
        Composite mainComposite = new Composite();
        Composite innerComposite = new Composite();
        Shape square = new Square();
        Shape triangle = new Triangle();
        Shape circle = new Circle();
        innerComposite.addComponent(square);
        innerComposite.addComponent(triangle);
        mainComposite.addComponent(innerComposite);
        mainComposite.addComponent(circle);
    }
}
