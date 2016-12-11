package model.dao.impl.files;

import model.dao.LexemeDao;
import model.dao.TextDao;

import java.io.*;
import java.util.Properties;

/**
 * dao factory as a singleton
 */
public class DaoFactory {
    /**
     * path to the property file
     */
    private final String propertyPath="src/main/resources/config.properties";

    /**
     * single instance of factory
     */
    private static DaoFactory instance;

    private DaoFactory(){
    }

    /**
     * this method returns the only instance of factory
     * @return instance of factory
     */
    public synchronized static DaoFactory getInstance(){
        if(instance==null){
            instance = new DaoFactory();
        }
        return instance;
    }

    /**
     * this method generates the reader for reading text from file
     * @return the bufered reader
     */
    public BufferedReader getReader(){
        BufferedReader reader = null;
        Properties property = new Properties();
        try{
            FileInputStream stream = new FileInputStream(propertyPath);
            property.load(stream);
            String path = property.getProperty("file.path");

            File f = new File(path);
            reader = new BufferedReader(new FileReader(f));
        }
        catch (IOException ex){
            System.err.println("Error! File doesn't exist");
        }
        return reader;
    }

    /**
     * @return the implementation of TextDao
     */
    public TextDao getTextDao(){
        return new TextDaoImpl();
    }

    public LexemeDao getLexemeDao(){
        return new LexemeDaoImpl();
    }
}
