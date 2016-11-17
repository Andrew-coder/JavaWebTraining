package model.entity;

/**
 * this enum describes all age groups of children
 */
public enum AgeGroup {
    NEWBORN(0,1), EARLY_CHILDHOOD(1,3), PRESCHOOL(3,7), PRIMARY_SCHOOL(7,11);

    /**
     * minimum age of the group
     */
    int minAge;

    /**
     * maximum age of the group
     */
    int maxAge;

    /**
     * constructor
     * @param minAge minimum age of the group
     * @param maxAge maximum age of the group
     */
    AgeGroup(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
}
