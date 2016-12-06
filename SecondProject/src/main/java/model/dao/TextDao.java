package model.dao;

import model.entity.Sentence;

import java.util.List;

/**
 * dao interface for Text entity
 */
public interface TextDao {
    /**
     * this method returns all text in string format
     * @return the string with text
     */
    String getWholeText();
}
