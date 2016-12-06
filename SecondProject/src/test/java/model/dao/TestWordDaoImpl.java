package model.dao;

import model.dao.impl.files.DaoFactory;
import model.entity.Letter;
import model.entity.LetterType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by andri on 12/5/2016.
 */

public class TestWordDaoImpl {
    private static final String TEST_STRING = "test";
    private static WordDao wordDao;
    @BeforeClass
    public static void init(){
        wordDao = DaoFactory.getInstance().getWordDao();
    }

    @Test
    public void testGetLettersFromString(){
        List<Letter> letters = Arrays.asList(   new Letter('t', LetterType.CONSONANT),
                                                new Letter('e',LetterType.VOWEL),
                                                new Letter('s',LetterType.CONSONANT),
                                                new Letter('t',LetterType.CONSONANT));
        assertEquals(letters, wordDao.getLettersFromString(TEST_STRING));
    }
}
