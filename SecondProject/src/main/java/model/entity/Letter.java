package model.entity;

import model.TextComposite;

/**
 * this entity describes the letter as a part of the word
 */
public class Letter extends Symbol implements Lexeme{
    /**
     * description of the letters type
     */
    private LetterType type;

    public Letter() {
    }

    public Letter(Character character, LetterType type) {
        super(character);
        this.type = type;
    }

    /**
     * this methods generate composite for letter
     * @return composite for letter
     */
    public TextComposite getLetterComposite(){
        TextComposite letterComposite = new TextComposite();
        letterComposite.addLexeme(this);
        return letterComposite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Letter)) return false;
        if(!this.character.equals(((Letter) o).character)) return false;
        Letter letter = (Letter) o;

        return type.equals(letter.type);

    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return getCharacter().toString();
    }
}
