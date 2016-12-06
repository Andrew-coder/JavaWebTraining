package model;

import model.entity.Lexeme;
import model.entity.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * this class stores text in composite format
 */
public class TextComposite implements Lexeme {
    /**
     * list of embedded components
     */
    private List<Lexeme> lexemeComponents;

    public TextComposite() {
        lexemeComponents = new ArrayList<>();
    }

    /**
     * this method adds the lexeme to the list of components
     * @param lexeme lexeme which will be added
     */
    public void addLexeme(Lexeme lexeme){
        lexemeComponents.add(lexeme);
    }

    public List<Lexeme> getLexemeComponents() {
        return lexemeComponents;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Lexeme lexeme:lexemeComponents){
            builder.append(lexeme.toString());
        }
        return builder.toString();
    }
}
