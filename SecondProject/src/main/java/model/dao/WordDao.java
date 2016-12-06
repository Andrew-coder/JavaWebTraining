package model.dao;

import model.entity.Letter;
import model.entity.Word;

import java.util.List;

/**
 * dao interface for Word entity
 */
public interface WordDao {
    /**
     * this method split sentence on words
     * @param text of sentence
     * @return the list of words
     */
    public List<Word> getWordsFromText(String text);

    /**
     * this method split word on letters
     * @param text of word
     * @return the list of letters
     */
    public List<Letter> getLettersFromString(String text);
}
