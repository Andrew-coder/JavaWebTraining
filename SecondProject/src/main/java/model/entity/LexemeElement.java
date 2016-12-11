package model.entity;

/**
 * this entity describes the terminal lexemes
 */
public class LexemeElement implements Lexeme {
    /**
     * content of the lexeme
     */
    private char content;
    /**
     * lexeme's type
     */
    private LexemeType lexemeType;

    public LexemeElement(char content, LexemeType lexemeType) {
        this.content = content;
        this.lexemeType = lexemeType;
    }

    public LexemeType getLexemeType() {
        return null;
    }

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }

    public void setLexemeType(LexemeType lexemeType) {
        this.lexemeType = lexemeType;
    }

    @Override
    public String toString() {
        return String.valueOf(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LexemeElement)) return false;

        LexemeElement element = (LexemeElement) o;

        if (getContent() != element.getContent()) return false;
        return getLexemeType() == element.getLexemeType();

    }

    @Override
    public int hashCode() {
        int result = (int) getContent();
        result = 31 * result + getLexemeType().hashCode();
        return result;
    }
}
