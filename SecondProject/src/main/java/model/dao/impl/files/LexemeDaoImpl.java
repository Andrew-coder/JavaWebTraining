package model.dao.impl.files;

import model.dao.LexemeDao;
import model.dao.parser.AbstractTextParser;
import model.dao.parser.TextParserImpl;
import model.entity.Lexeme;
import model.entity.LexemeContainer;
import model.entity.LexemeType;

import java.util.List;
import java.util.function.Predicate;

/**
 * implementation of lexemeDao
 */
public class LexemeDaoImpl implements LexemeDao {
    AbstractTextParser parser;

    public LexemeDaoImpl() {
        parser = new TextParserImpl();
    }

    public LexemeDaoImpl(AbstractTextParser parser) {
        this.parser = parser;
    }

    @Override
    public LexemeContainer getAllLexems(String text) {
        return parser.parse(text);
    }

    @Override
    public LexemeContainer getLexemsByType(String text, LexemeType type) {
        if(type==LexemeType.TEXT || type== LexemeType.SENTENCE)
            return getAllLexems(text);
        else if(type==LexemeType.WORD)
            return getWordsContainer(text);
        else if(type==LexemeType.LETTER)
            return getLettersContainer(text);
        else if(type==LexemeType.DELIMITER)
            return getDelimitersContainer(text);
        else return null;
    }

    public LexemeContainer getWordsContainer(String text){
        LexemeContainer commonContainer = getAllLexems(text);
        LexemeContainer wordContainer = new LexemeContainer();
        for(Lexeme sentenceContainer:commonContainer.getComponents()){
            ((LexemeContainer)sentenceContainer).getComponents().stream().
                    filter(container->container.getLexemeType()==LexemeType.WORD).
                    forEach(wordContainer::addComponent);
        }
        return wordContainer;
    }

    public LexemeContainer getLettersContainer(String text){
        LexemeContainer letterContainer = new LexemeContainer();
        letterContainer.setLexemeType(LexemeType.LETTER);
        getWordsContainer(text).getComponents().stream().
                filter(container -> container.getLexemeType()==LexemeType.LETTER).
                forEach(letterContainer::addComponent);
        return letterContainer;
    }

    public LexemeContainer getDelimitersContainer(String text){
        LexemeContainer delimiterContainer = new LexemeContainer();
        delimiterContainer.setLexemeType(LexemeType.DELIMITER);
        getWordsContainer(text).getComponents().stream().
                filter(container -> container.getLexemeType()==LexemeType.DELIMITER).
                forEach(delimiterContainer::addComponent);
        return delimiterContainer;
    }

    @Override
    public void insertLexeme(Lexeme lexeme) {

    }

    @Override
    public void updateLexeme(Lexeme lexeme) {

    }

    @Override
    public void deleteLexeme(Lexeme lexeme) {

    }
}
