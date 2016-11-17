package model.entity;

/**
 * Created by andri on 11/14/2016.
 */
public class Toy {
    /**
     * the price of toy
     */
    private int price;

    /**
     * type of the toy (car, dall, ball, cube)
     */
    private ToyType type;

    /**
     * constructor
     * @param price price of the toy
     * @param type type of the toy
     */
    public Toy(int price, ToyType type) {
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(type.getName())
                                .append(" ").append(price).toString();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ToyType getType() {
        return type;
    }

    public void setType(ToyType type) {
        this.type = type;
    }
}
