package model.entity;

/**
 * this enum describrs all types of lexemes
 */
public enum LexemeType {
    LETTER(false),                          // is not a composite
    DELIMITER(false),                       // is not a composite
    TEXT(true),                             // it is composite
    SENTENCE(true),                         // it is composite
    WORD(true);                             // it is composite

    private boolean composite;
    boolean isComposite(){
        return composite;
    }
    LexemeType(boolean composite){
        this.composite = composite;
    }
}
