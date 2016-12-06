package model.dao.impl.files;

import model.dao.TextDao;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * implementation of TextDao
 */
public class TextDaoImpl implements TextDao {
    /**
     * this method returns all text in string format
     * @return the string with text
     */
    @Override
    public String getWholeText() {
        StringBuilder textBuilder= new StringBuilder();
        try(BufferedReader reader = DaoFactory.getInstance().getReader()){
            String line;
            while ((line = reader.readLine()) != null) {
                textBuilder.append(line);
            }
        }
        catch (IOException ex){
            System.err.println("Error while reading text!");
        }
        return textBuilder.toString();
    }
}
