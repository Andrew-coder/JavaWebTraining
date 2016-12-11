package dao;

import model.dao.TextDao;
import model.dao.impl.files.DaoFactory;
import model.dao.impl.files.TextDaoImpl;
import model.entity.LexemeContainer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestTextDao {

    FileReader fileReader;
    BufferedReader reader;
    DaoFactory factory;
    TextDao textDao;
    @Before
    public void init() throws FileNotFoundException {
        fileReader = mock(FileReader.class);
        reader = new BufferedReader(fileReader);
        factory=mock(DaoFactory.class);
        textDao = mock(TextDaoImpl.class);
    }
    @Test
    public void testGetWholeText()throws IOException {
        when(factory.getReader()).thenReturn(reader);
        when(textDao.getWholeText()).thenReturn("Example of string.");
        assertEquals("Example of string.", textDao.getWholeText());
    }
}
