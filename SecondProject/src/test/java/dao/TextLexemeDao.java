package dao;

import model.dao.LexemeDao;
import model.dao.impl.files.DaoFactory;
import model.dao.impl.files.LexemeDaoImpl;
import model.dao.parser.TextParserImpl;
import model.entity.LexemeContainer;
import model.entity.LexemeType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TextLexemeDao {
    @Mock
    TextParserImpl parser;
    @Mock
    LexemeContainer container;
    @Mock
    DaoFactory factory;


    @Before
    public void setUp(){
        when(parser.parse(anyString())).thenReturn(container);
        when(factory.getLexemeDao()).thenReturn(new LexemeDaoImpl(parser));
    }

    @Test
    public void testGetAllLexems(){
        LexemeDao lexemeDao = factory.getLexemeDao();
        lexemeDao.getAllLexems("some text");
        verify(parser, times(1)).parse(anyString());
    }
}
