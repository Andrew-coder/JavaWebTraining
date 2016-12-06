package model.dao.impl.files;

import model.dao.SentenceDao;
import model.dao.WordDao;
import model.entity.Delimiter;
import model.entity.Sentence;
import model.entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * implementation of SentenceDao
 */
public class SentenceDaoImpl implements SentenceDao {
    private static final String COMMON_DELIMITER = "[\\s,-:;.!?]";
    private static final String SENTENCE_DELIMITERS_PATTERN = "[.!?]";
    private static final String DELIMITERS_PATTERN = "[\\s,-:;]";

    /**
     * this method splits the text on sentences
     * @param text which will be splitted
     * @return the list of sentences
     */
    @Override
    public List<Sentence> getSentencesFromText(String text) {
        List<Sentence> sentences = new ArrayList<>();
        int cursor = 0;
        StringBuilder sentenceBuilder = new StringBuilder();
        while(text.length()>cursor){
            char currentSymbol= text.charAt(cursor);
            if(Pattern.matches(SENTENCE_DELIMITERS_PATTERN, String.valueOf(currentSymbol))){
                sentenceBuilder.append(currentSymbol);
                sentences.add(getSentenceFromText(sentenceBuilder.toString()));
                sentenceBuilder.setLength(0);
                sentenceBuilder.trimToSize();
            }
            else {
                sentenceBuilder.append(currentSymbol);
            }
            ++cursor;
        }
        return sentences;
    }

    /**
     * this sentence return the single sentence
     * @param text the text of sentence
     * @return the single sentence
     */
    @Override
    public Sentence getSentenceFromText(String text){
        WordDao wordDao = new WordDaoImpl();
        Sentence sentence = new Sentence();
        int cursor = 0;
        StringBuilder wordBuilder = new StringBuilder();
        wordBuilder.trimToSize();
        while(text.length()>cursor) {
            char currentSymbol= text.charAt(cursor);
            if(Pattern.matches(COMMON_DELIMITER, String.valueOf(currentSymbol))){
                if(wordBuilder.capacity()>0 &&
                        Pattern.matches(DELIMITERS_PATTERN, String.valueOf(currentSymbol))) {

                    sentence.addLexeme(new Word(wordDao.getLettersFromString(wordBuilder.toString())));
                    wordBuilder.setLength(0);
                    wordBuilder.trimToSize();
                    sentence.addLexeme(Delimiter.getDelimiterAsChar(currentSymbol));
                }

                else if(Pattern.matches(SENTENCE_DELIMITERS_PATTERN, String.valueOf(currentSymbol))){
                    sentence.addLexeme(new Word(wordDao.getLettersFromString(wordBuilder.toString())));
                    sentence.addLexeme(Delimiter.getDelimiterAsChar(currentSymbol));
                    break;
                }
            }
            else{
                wordBuilder.append(currentSymbol);
            }
            ++cursor;
        }
        return sentence;
    }
}
