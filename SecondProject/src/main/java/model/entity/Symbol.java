package model.entity;

/**
 * this class defines the base entity for letter
 */
public class Symbol {
    /**
     * character which defines the symbol
     */
    protected Character character;

    public Symbol() {
    }

    public Symbol(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }
}
