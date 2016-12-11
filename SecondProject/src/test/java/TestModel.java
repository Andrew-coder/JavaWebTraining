import model.Model;
import model.dao.parser.AbstractTextParser;
import model.dao.parser.TextParserImpl;
import model.entity.LexemeContainer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andri on 12/9/2016.
 */
public class TestModel {
    public static final String TEXT = "Example of simple and unique text! This example is very easy.";
    AbstractTextParser parser;
    Model model;

    @Before
    public void init(){
        parser = new TextParserImpl();
        model = new Model();
        model.setContainer(parser.parse(TEXT));
    }

    @Test
    public void testFindUniqueWord(){
        assertEquals("of", model.findUniqueWord());
    }
}
