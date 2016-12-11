package model.dao.parser;

import model.cash.LexemeFactory;
import model.cash.LexemeFactoryImpl;
import model.entity.LexemeContainer;
import model.entity.LexemeElement;
import model.entity.LexemeType;

import java.util.regex.Pattern;

import static model.dao.parser.RegularExp.CONSONANTS_PATTERN;
import static model.dao.parser.RegularExp.VOWELS_PATTERN;

/**
 * implementation of abstract text parser
 */
public class TextParserImpl implements AbstractTextParser {
    private LexemeFactory lexemeFactory = LexemeFactoryImpl.getInstance();

    /**
     * this method splits text on sentences
     * @param text which will be splitted
     * @return container for sentences
     */
    @Override
    public LexemeContainer parse(String text) {
        LexemeContainer container = new LexemeContainer();
        container.setLexemeType(LexemeType.TEXT);
        StringBuilder sentenceBuilder = new StringBuilder();
        int cursor = 0;
        while (cursor < text.length()) {
            char currentSymbol = text.charAt(cursor);
            if (Pattern.matches(RegularExp.SENTENCE_DELIMITERS_PATTERN, String.valueOf(currentSymbol))) {
                sentenceBuilder.append(currentSymbol);
                container.addComponent(parseSentence(sentenceBuilder.toString()));
                sentenceBuilder.setLength(0);
                sentenceBuilder.trimToSize();
            } else {
                sentenceBuilder.append(currentSymbol);
            }
            ++cursor;
        }
        return container;
    }

    /**
     * this method splits the sentence on words
     * @param textSentence which will be splitted
     * @return contaner for words
     */
    public LexemeContainer parseSentence(String textSentence) {
        LexemeContainer container = new LexemeContainer();
        container.setLexemeType(LexemeType.SENTENCE);
        int cursor = 0;
        StringBuilder wordBuilder = new StringBuilder();
        wordBuilder.trimToSize();
        while(textSentence.length()>cursor) {
            char currentSymbol= textSentence.charAt(cursor);
            if(Pattern.matches(RegularExp.COMMON_DELIMITER, String.valueOf(currentSymbol))){
                if(wordBuilder.capacity()>0 &&
                        Pattern.matches(RegularExp.WORDS_PATTERN, String.valueOf(currentSymbol))) {
                    container.addComponent(parceWord(wordBuilder.toString()));
                    wordBuilder.setLength(0);
                    wordBuilder.trimToSize();
                    container.addComponent(parceDelimiter(currentSymbol));
                }
                else if(Pattern.matches(RegularExp.SENTENCE_DELIMITERS_PATTERN, String.valueOf(currentSymbol))){
                    container.addComponent(parceWord(wordBuilder.toString()));
                    container.addComponent(parceDelimiter(currentSymbol));
                    break;
                }
            }
            else{
                wordBuilder.append(currentSymbol);
            }
            ++cursor;
        }
        return container;
    }

    /**
     * this method splits the word on letters
     * @param textWord which will be splitted
     * @return container for letters
     */
    public LexemeContainer parceWord(String textWord) {
        LexemeContainer container = new LexemeContainer();
        container.setLexemeType(LexemeType.WORD);
        for (Character c:textWord.toCharArray()){
            container.addComponent(parceSymbol(c));
        }
        return container;
    }

    /**
     * this method parce delimiters
     * @param c content
     * @return container for delimiter
     */
    public LexemeElement parceDelimiter(char c){
        LexemeElement element = lexemeFactory.getElement(LexemeType.DELIMITER, c);
        return element;
    }

    /**
     * this method parce letters
     * @param c content
     * @return container for letter
     */
    public LexemeElement parceSymbol(char c) {
        LexemeElement element = lexemeFactory.getElement(LexemeType.LETTER, Character.toLowerCase(c));
        return element;
    }
}
