package model.entity;

import model.TextComposite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 12/4/2016.
 */
public class Text implements Lexeme{
    private List<Sentence> sentences;

    public Text() {
        sentences = new ArrayList<>();
    }

    public List<Word> getAllWords(){
        List<Word> allWords = new ArrayList<>();
        for(Sentence sentence:sentences){
            allWords.addAll(sentence.getWords());
        }
        return allWords;
    }

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
