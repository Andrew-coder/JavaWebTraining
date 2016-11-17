package model.entity;

/**
 * this enum describes the type of the toy
 */
public enum ToyType {
    CAR("car"), DOLL("dall"), BALL("ball"), CUBE("cube");
    /**
     * the name of the toy
     */
    private String name;

    /**
     * constructor
     * @param name the name of the toy
     */
    ToyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
