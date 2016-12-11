package model;

import model.entity.Lexeme;
import model.entity.LexemeContainer;
import model.entity.LexemeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by andri on 12/4/2016.
 */
public class Model {
    /**
     * text composite
     */
    private LexemeContainer container;

    public Model(){
        container = new LexemeContainer();
    }

    public Model(LexemeContainer container) {
        this.container = container;
    }

    /**
     * this method which finds the unique word from 1st sentence in a whole text
     * @return the unique word
     */
    public String findUniqueWord(){
        LexemeContainer firstSentenceContainer= new LexemeContainer();
        firstSentenceContainer.setLexemeType(LexemeType.SENTENCE);
        LexemeContainer otherPartContainer = new LexemeContainer();
        otherPartContainer.setLexemeType(LexemeType.SENTENCE);
        ((LexemeContainer) container.getComponents().get(0)).getComponents().stream().
                filter(container -> container.getLexemeType()== LexemeType.WORD).
                forEach(firstSentenceContainer::addComponent);
        for(int i=1;i<container.getComponents().size();++i){
            LexemeContainer tempContainer = (LexemeContainer) container.getComponents().get(i);
            tempContainer.getComponents().stream().forEach(otherPartContainer::addComponent);
        }
        for(Lexeme word:firstSentenceContainer.getComponents()){
            if(!otherPartContainer.getComponents().contains(word))
                return word.toString();
        }
        return null;
    }

    public LexemeContainer getContainer() {
        return container;
    }

    public void setContainer(LexemeContainer container) {
        this.container = container;
    }
}
