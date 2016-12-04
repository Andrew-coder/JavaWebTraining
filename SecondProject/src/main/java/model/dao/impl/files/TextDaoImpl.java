package model.dao.impl.files;

import model.dao.TextDao;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by andri on 12/4/2016.
 */
public class TextDaoImpl implements TextDao {
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
