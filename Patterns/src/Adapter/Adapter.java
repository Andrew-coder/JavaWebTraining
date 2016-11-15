package Adapter;

/**
 * Created by andri on 11/15/2016.
 */
public interface VectorGraphicsInterface {
    void drawLine();
    void drawСircle();
}

public class RasterGraphics {
    public void drawRasterLine() {
        System.out.println("draw line");
    }

    public void drawRasterSircle() {
        System.out.println("draw sircle");
    }
}

public class Adapter implements VectorGraphicsInterface {
    RasterGraphics graphics;

    public Adapter(RasterGraphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public void drawLine() {
        graphics.drawRasterLine();
    }

    @Override
    public void drawСircle() {
        graphics.drawRasterSircle();
    }
}

public class Main {
    public static void main(String[] args) {
        VectorGraphicsInterface graphic = new Adapter(new RasterGraphics());
        graphic.drawLine();
        graphic.drawСircle();
    }
}
