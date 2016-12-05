package model.entity;

import model.TextComposite;

import java.util.List;

/**
 * Created by andri on 12/4/2016.
 */
public class Word implements Lexeme{
    private List<Letter> letters;

    public Word() {
    }

    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    public TextComposite getWordComposite(){
        TextComposite wordComposite = new TextComposite();
        for(Letter letter:letters){
            wordComposite.addLexeme(letter.getLetterComposite());
        }
        return wordComposite;
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for(Letter letter:letters)
            word.append(letter.getCharacter());
        return word.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        return letters.equals(word.letters);

    }

    @Override
    public int hashCode() {
        return letters.hashCode();
    }
}
