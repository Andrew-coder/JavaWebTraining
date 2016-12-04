package model.dao.impl.files;

import model.dao.SentenceDao;
import model.dao.TextDao;
import model.dao.WordDao;

import java.io.*;
import java.util.Properties;


/**
 * Created by andri on 12/4/2016.
 */
public class DaoFactory {
    private final String propertyPath="src/main/resources/config.properties";
    private static DaoFactory instance;

    private DaoFactory(){

    }

    public static DaoFactory getInstance(){
        if(instance==null){
            instance = new DaoFactory();
        }
        return instance;
    }

    public BufferedReader getReader(){
        BufferedReader reader = null;
        Properties property = new Properties();
        try{
            FileInputStream stream = new FileInputStream(propertyPath);
            property.load(stream);
            String path = property.getProperty("file.path");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            File f = new File(path);
            reader = new BufferedReader(new FileReader(f));
        }
        catch (IOException ex){
            System.err.println("Error! File doesn't exist");
        }
        return reader;
    }

    public SentenceDao getSentenceDao(){
        return new SentenceDaoImpl();
    }

    public WordDao getWordDao(){
        return new WordDaoImpl();
    }

    public TextDao getTextDao(){
        return new TextDaoImpl();
    }
}
