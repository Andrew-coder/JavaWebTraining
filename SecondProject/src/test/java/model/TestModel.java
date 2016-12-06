package model;

import model.dao.SentenceDao;
import model.dao.TextDao;
import model.dao.impl.files.DaoFactory;
import model.entity.Letter;
import model.entity.LetterType;
import model.entity.Text;
import model.entity.Word;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by andri on 12/5/2016.
 */
public class TestModel {
    private static final String TEST_STRING = "Example of simple string. Second string!";
    SentenceDao sentenceDao;
    Model model;
    Text text;
    @Before
    public void init(){
        sentenceDao = DaoFactory.getInstance().getSentenceDao();
        text =new Text(sentenceDao.getSentencesFromText(TEST_STRING));
        model = new Model();
    }

    @Test
    public void testFindUniqueWord(){
        Word word = new Word(Arrays.asList( new Letter('e', LetterType.VOWEL),
                                            new Letter('x',LetterType.CONSONANT),
                                            new Letter('a',LetterType.VOWEL),
                                            new Letter('m',LetterType.CONSONANT),
                                            new Letter('p',LetterType.CONSONANT),
                                            new Letter('l',LetterType.CONSONANT),
                                            new Letter('e',LetterType.VOWEL)));
        assertEquals(word.toString(), model.findUniqueWord(text).toString());
    }
}
