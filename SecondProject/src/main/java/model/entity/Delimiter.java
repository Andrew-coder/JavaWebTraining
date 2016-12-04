package model.entity;

/**
 * Created by andri on 12/4/2016.
 */
public enum Delimiter implements Lexeme{
    DOT('.'), COLONS(':'), SEMICOLON(';'), QUESTION_MARK('?'), EXCLAMATION_MARK('!'), COMA(','), DASH('-');

    private Character character;

    Delimiter(Character character) {
        this.character = character;
    }

    public Character getDelimiter(){
        return character;
    }

    public static Delimiter getDelimiterAsChar(Character c){
        for(Delimiter delimiter:values()){
            if(delimiter.getDelimiter().equals(c))
                return delimiter;
        }
        return null;
    }
}