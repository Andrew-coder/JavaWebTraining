package model.entity;

import model.TextComposite;

import java.util.ArrayList;
import java.util.List;

/**
 * this entity describes the sentence as a part of text
 */
public class Sentence implements Lexeme {
    private List<Lexeme> lexemes;

    public Sentence() {
        lexemes = new ArrayList<>();
    }

    public Sentence(String sentence) {

    }

    /**
     * this method generate the composite for sentence
     * @return composite for sentence
     */
    public TextComposite getSentenceComposite(){
        TextComposite sentenceComposite = new TextComposite();
        for(Lexeme lexeme:lexemes){
            TextComposite lexemeComposite = new TextComposite();
            if(lexeme instanceof Word)
                lexemeComposite.addLexeme(((Word)lexeme).getWordComposite());
            else if(lexeme instanceof Delimiter)
                lexemeComposite.addLexeme(((Delimiter)lexeme).getDelimiterComposite());
            sentenceComposite.addLexeme(lexemeComposite);
        }
        return sentenceComposite;
    }

    /**
     * this method returns all words from sentence
     * @return words
     */
    public List<Word> getWords(){
        List<Word> words = new ArrayList<>();
        for(Lexeme lexeme: lexemes){
            if(lexeme instanceof Word)
                words.add((Word) lexeme);
        }
        return words;
    }

    /**
     * this method returns all delimiters from sentence
     * @return delimiters
     */
    public List<Delimiter> getDelimiters(){
        List<Delimiter> delimiters = new ArrayList<>();
        for(Lexeme lexeme: lexemes){
            if(lexeme instanceof Delimiter)
                delimiters.add((Delimiter) lexeme);
        }
        return delimiters;
    }

    /**
     * this method adds given lexeme in lexeme list
     * @param lexeme which will be added
     */
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
