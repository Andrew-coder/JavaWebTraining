package model.entity;

import java.util.Comparator;

/**
 * this enum describes all methods of sorting toys
 */
public enum SortMethod {
    BY_TOYS_NAME((toy1, toy2) -> toy1.getType().getName().compareTo(toy2.getType().getName())),

    BY_TOYS_PRICE((toy1, toy2) -> Integer.compare(toy1.getPrice(), toy2.getPrice())),

    BY_TOYS_PRICE_BACK((toy1, toy2) -> Integer.compare(toy2.getPrice() ,toy1.getPrice()));
    /**
     * comparator for sorting
     */
    private Comparator<Toy> comparator;

    /**
     * constructor
     * @param comparator comparator for sorting
     */
    SortMethod(Comparator<Toy> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Toy> getComparator() {
        return comparator;
    }
}
