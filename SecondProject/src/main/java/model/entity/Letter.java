package model.entity;

/**
 * Created by andri on 12/4/2016.
 */
public class Letter extends Symbol{
    private LetterType type;

    public Letter() {
    }

    public Letter(LetterType type) {
        this.type = type;
    }

    public Letter(Character character, LetterType type) {
        super(character);
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Letter)) return false;
        if(!this.character.equals(((Letter) o).character)) return false;
        Letter letter = (Letter) o;

        return type == letter.type;

    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}
