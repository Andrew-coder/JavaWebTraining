package model.entity;

/**
 * Created by andri on 11/14/2016.
 */
public class Child {
    /**
     * name of the child
     */
    private String name;

    /**
     * age group of the child (NEWBORN, EARLY CHILDHOOD, PRIMARY SCHOOL)
     */
    private AgeGroup group;

    /**
     * constructor
     * @param name name of the child
     * @param group age group of the child
     */
    public Child(String name, AgeGroup group) {
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", group=" + group +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgeGroup getGroup() {
        return group;
    }

    public void setGroup(AgeGroup group) {
        this.group = group;
    }
}
