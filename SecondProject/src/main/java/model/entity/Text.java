package model.entity;

import model.TextComposite;

import java.util.ArrayList;
import java.util.List;

/**
 * this entity describes the text in general
 */
public class Text implements Lexeme{
    /**
     * sentences which define the text
     */
    private List<Sentence> sentences;

    public Text() {
        sentences = new ArrayList<>();
    }

    /**
     * this method returns all words from text
     * @return the list of words
     */
    public List<Word> getAllWords(){
        List<Word> allWords = new ArrayList<>();
        for(Sentence sentence:sentences){
            allWords.addAll(sentence.getWords());
        }
        return allWords;
    }

    /**
     * this method generate the composite for text
     * @return composite for text
     */
    public TextComposite getTextComposite(){
        TextComposite textComposite = new TextComposite();
        for(Sentence sentence:sentences){
            textComposite.addLexeme(sentence.getSentenceComposite());
        }
        return textComposite;
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
