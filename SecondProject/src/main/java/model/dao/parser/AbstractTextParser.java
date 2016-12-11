package model.dao.parser;

import model.entity.Lexeme;
import model.entity.LexemeContainer;

import java.util.List;

/**
 * interface which defines the functionality of text parser
 */
public interface AbstractTextParser {
    LexemeContainer parse(String text);
}
