package model;

import model.entity.Text;
import model.entity.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 12/4/2016.
 */
public class Model {
    private Text text;

    public Model() {
        text = new Text();
    }

    public Model(Text text) {
        this.text = text;
    }

    public String findUniqueWord(){
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

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
