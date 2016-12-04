package model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 12/4/2016.
 */
public class Text {
    private List<Sentence> sentences;

    public Text() {
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Word> getAllWords(){
        List<Word> allWords = new ArrayList<>();
        for(Sentence sentence:sentences){
            allWords.addAll(sentence.getWords());
        }
        return allWords;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
