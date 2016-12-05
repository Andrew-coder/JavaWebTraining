package model;

import model.entity.Lexeme;
import model.entity.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 12/5/2016.
 */
public class TextComposite implements Lexeme {
    private List<Lexeme> lexemeComponents;

    public TextComposite() {
        lexemeComponents = new ArrayList<>();
    }

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
