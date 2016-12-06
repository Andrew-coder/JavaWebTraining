package model.entity;

import model.TextComposite;

/**
 * this enum describes all possible delimiters in text
 */
public enum Delimiter implements Lexeme{
    DOT('.'), COLONS(':'), SEMICOLON(';'), QUESTION_MARK('?'), EXCLAMATION_MARK('!'),
    COMA(','), DASH('-'), WHITE_SPACE(' '), ENTER('\n');

    /**
     * character which determines the delimiter
     */
    private Character character;

    Delimiter(Character character) {
        this.character = character;
    }

    public Character getDelimiter(){
        return character;
    }

    /**
     * this method generates composite for dilimiters
     * @return composite for delimiter
     */
    public TextComposite getDelimiterComposite(){
        TextComposite delimiterComposite = new TextComposite();
        delimiterComposite.addLexeme(this);
        return delimiterComposite;
    }

    /**
     * this method find the delimiter by appropriate character
     * @param c character, by which the delimiter will be found
     * @return the delimiter of character
     */
    public static Delimiter getDelimiterAsChar(Character c){
        for(Delimiter delimiter:values()){
            if(delimiter.getDelimiter().equals(c))
                return delimiter;
        }
        return null;
    }

    @Override
    public String toString() {
        return character.toString();
    }
}
