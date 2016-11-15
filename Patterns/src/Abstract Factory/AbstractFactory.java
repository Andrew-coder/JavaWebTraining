public interface IButton {
    void paint();
}

public interface IGUIFactory {
    public IButton createButton();
}

public class WinFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        return new WinButton();
    }
}

public class OSXFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        return new OSXButton();
    }
}

public class WinButton implements IButton {
    @Override
    public void paint() {
        System.out.println("WinButton");
    }
}

public class OSXButton implements IButton {
    @Override
    public void paint() {
        System.out.println("OSX button");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        IGUIFactory factory = new WinFactory();
        IButton button = factory.createButton();
        button.paint();
        factory = new OSXFactory();
        button = factory.createButton();
        button.paint();
    }
}