package model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * this entity describes the lexeme container as composite
 * which stores the lexeme elements
 */
public class LexemeContainer implements Lexeme {
    /**
     * type of container
     */
    private LexemeType lexemeType;
    /**
     * list of components
     */
    private List<Lexeme> components;

    public LexemeContainer() {
        components = new ArrayList<>();
    }

    public LexemeContainer(LexemeType lexemeType, List<Lexeme> components) {
        this.lexemeType = lexemeType;
        this.components = components;
    }

    /**
     * this method adds lexeme to the list of lexemes
     * @param lexeme lexeme which will be added
     */
    public void addComponent(Lexeme lexeme){
        components.add(lexeme);
    }

    /**
     * this method removes lexeme from the list of lexemes
     * @param lexeme lexeme, which will be removed
     */
    public void removeCompoent(Lexeme lexeme){
        components.remove((LexemeContainer)lexeme);
    }

    public LexemeType getLexemeType() {
        return lexemeType;
    }

    public void setLexemeType(LexemeType lexemeType) {
        this.lexemeType = lexemeType;
    }

    public List<Lexeme> getComponents() {
        return components;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Lexeme lexeme:components){
            builder.append(lexeme.toString());
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LexemeContainer)) return false;

        LexemeContainer container = (LexemeContainer) o;

        if (getLexemeType() != container.getLexemeType()) return false;
        return getComponents().equals(container.getComponents());

    }

    @Override
    public int hashCode() {
        int result = getLexemeType().hashCode();
        result = 31 * result + getComponents().hashCode();
        return result;
    }
}
