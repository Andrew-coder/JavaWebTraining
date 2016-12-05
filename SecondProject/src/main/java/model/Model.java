package model;

import model.entity.Lexeme;
import model.entity.Sentence;
import model.entity.Text;
import model.entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by andri on 12/4/2016.
 */
public class Model {
    private TextComposite textComposite;

    public Model() {
        textComposite = new TextComposite();
    }

    public Model(TextComposite textComposite) {
        this.textComposite = textComposite;
    }

    public String findUniqueWord(Text text){
        List<Word> allWords = new ArrayList<>();
        if(text.getSentences().size()>1) {
            for(int i=1;i<text.getSentences().size();++i){
                allWords.addAll(text.getSentences().get(i).getWords());
            }
            for (Word word : text.getSentences().get(0).getWords()) {
                if (!allWords.contains(word))
                    return word.toString();
            }
            return null;
        }
        else
            return null;
    }

    public TextComposite getTextComposite() {
        return textComposite;
    }

    public void setText(Text text) {
        checkText(text);
        textComposite.addLexeme(text.getTextComposite());
    }

    public void checkText(Text text) {
        Objects.requireNonNull(text,"text is emty!");
        if(text.getSentences().isEmpty())
            throw new RuntimeException("text hasn't any sentences");
        for (Sentence sentece: text.getSentences()) {
            if(sentece.getWords().isEmpty())
                throw new RuntimeException("sentence hasn't any words");
        }
    }
}
