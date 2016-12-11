package model.dao.parser;

/**
 * Created by andri on 12/8/2016.
 */
public interface RegularExp {
    String COMMON_DELIMITER = "[\\s,-:;.!?]";
    String SENTENCE_DELIMITERS_PATTERN = "[.!?]";
    String VOWELS_PATTERN = "[aeiyouAEIYOU]";
    String CONSONANTS_PATTERN = "[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]";
    String WORDS_PATTERN = "[\\s,-:;]";
}
