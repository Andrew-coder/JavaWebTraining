package model.dao;

import model.entity.Sentence;

import java.util.List;

/**
 * dao interface for sentence entity
 */
public interface SentenceDao {
    /**
     * this method splits the text on sentences
     * @param text which will be splitted
     * @return the list of sentences
     */
    List<Sentence> getSentencesFromText(String text);

    /**
     * this sentence return the single sentence
     * @param text the text of sentence
     * @return the single sentence
     */
    Sentence getSentenceFromText(String text);
}
