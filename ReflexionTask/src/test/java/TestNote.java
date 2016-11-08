import model.Date;
import model.Month;
import model.Note;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by andri on 11/8/2016.
 */
public class TestNote {
    @Test
    public void testCalculateTimeToBirth() {
        Note note = new Note("Andriy","Ivanyuk","Olehovich","+380958016294"
                ,new Date(),new Date(25, Month.APRIL, 1997));
        Assert.assertEquals(note.calculateTimeToBirth(note.getCurrentDate(),note.getBirthDate()),166);
    }
}

