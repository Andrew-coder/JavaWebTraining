package model.dao.impl.files;

import model.dao.WordDao;
import model.entity.Letter;
import model.entity.LetterType;
import model.entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by andri on 12/4/2016.
 */
public class WordDaoImpl implements WordDao {
    private static final String DELIMITERS_PATTERN = "[\\s,-:;.!?]";
    private static final String VOWELS_PATTERN = "[aeiyouAEIYOU]";
    private static final String CONSONANTS_PATTERN = "[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]";

    @Override
    public List<Word> getWordsFromText(String text) {
        List<Word> words = new ArrayList<>();
        int cursor = 0;
        StringBuilder wordBuilder = new StringBuilder();
        while(text.length()>cursor){
            char currentSymbol= text.charAt(cursor);
            if(Pattern.matches(DELIMITERS_PATTERN, String.valueOf(currentSymbol))){
                words.add(new Word(getLettersFromString(wordBuilder.toString())));
                wordBuilder.setLength(0);
            }
            else {
                wordBuilder.append(Character.toLowerCase(currentSymbol));
            }
            ++cursor;
        }
        return words;
    }

    @Override
    public List<Letter> getLettersFromString(String text) {
        List<Letter> letters = new ArrayList<>();
        for (Character c:text.toCharArray()){
            if(Pattern.matches(VOWELS_PATTERN, String.valueOf(c))){
                letters.add(new Letter(Character.toLowerCase(c), LetterType.VOWEL));
            }
            else if(Pattern.matches(CONSONANTS_PATTERN, String.valueOf(c))){
                letters.add(new Letter(Character.toLowerCase(c), LetterType.CONSONANT));
            }
            else throw new RuntimeException("The words contains unknow character");
        }
        return letters;
    }
}
