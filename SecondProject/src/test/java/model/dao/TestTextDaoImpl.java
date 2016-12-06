package model.dao;
import model.dao.impl.files.DaoFactory;
import model.dao.impl.files.TextDaoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by andri on 12/5/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTextDaoImpl {
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
        //verify(reader).readLine();
        when(textDao.getWholeText()).thenReturn("Example of string.");
        assertEquals("Example of string.", textDao.getWholeText());
    }
}
