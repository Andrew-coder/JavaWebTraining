package model.dao;

import model.entity.Sentence;

import java.util.List;

/**
 * Created by andri on 12/4/2016.
 */
public interface SentenceDao {
    List<Sentence> getSentencesFromText(String text);
    Sentence getSentenceFromText(String text);
}
