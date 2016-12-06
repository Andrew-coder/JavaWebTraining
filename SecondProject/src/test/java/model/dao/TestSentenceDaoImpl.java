package model.dao;


import model.dao.impl.files.DaoFactory;
import model.dao.impl.files.SentenceDaoImpl;
import model.entity.Sentence;
import model.entity.Word;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by andri on 12/5/2016.
 */

public class TestSentenceDaoImpl {
    private static final String TEST_STRING = "Example of simple string. Second string!";
    private static final String TEST_SINGLE_SENTENCE = "Example of sentence!";
    SentenceDao sentenceDao;
    @BeforeClass
    public void init(){
        sentenceDao = DaoFactory.getInstance().getSentenceDao();
    }

    @Test
    public void testGetSentencesFromText(){
        assertTrue(sentenceDao.getSentencesFromText(TEST_STRING).size()==2);
    }
}
