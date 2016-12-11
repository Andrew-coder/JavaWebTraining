package model.dao;

import model.entity.Lexeme;
import model.entity.LexemeContainer;
import model.entity.LexemeType;

import java.util.List;

/**
 * dao interface for base lexeme
 */
public interface LexemeDao {
    LexemeContainer getAllLexems(String text);
    LexemeContainer getLexemsByType(String text, LexemeType type);
    void insertLexeme(Lexeme lexeme);
    void updateLexeme(Lexeme lexeme);
    void deleteLexeme(Lexeme lexeme);
}
