package model.dao;

import model.entity.Letter;
import model.entity.Word;

import java.util.List;

/**
 * Created by andri on 12/4/2016.
 */
public interface WordDao {
    public List<Word> getWordsFromText(String text);
    public List<Letter> getLettersFromString(String text);
}
