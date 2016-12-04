package model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 12/4/2016.
 */
public class Sentence {
    private List<Lexeme> lexemes = new ArrayList<>();

    public Sentence() {
    }

    public Sentence(String sentence) {

    }

    public List<Word> getWords(){
        List<Word> words = new ArrayList<>();
        for(Lexeme lexeme: lexemes){
            if(lexeme instanceof Word)
                words.add((Word) lexeme);
        }
        return words;
    }

    public List<Delimiter> getDelimiters(){
        List<Delimiter> delimiters = new ArrayList<>();
        for(Lexeme lexeme: lexemes){
            if(lexeme instanceof Delimiter)
                delimiters.add((Delimiter) lexeme);
        }
        return delimiters;
    }

    public void addLexeme(Lexeme lexeme){
        lexemes.add(lexeme);
    }

    public List<Lexeme> getLexemes() {
        return lexemes;
    }

    public void setLexemes(List<Lexeme> lexemes) {
        this.lexemes = lexemes;
    }
}
