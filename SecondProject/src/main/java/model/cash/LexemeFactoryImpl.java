package model.cash;

import model.entity.Lexeme;
import model.entity.LexemeContainer;
import model.entity.LexemeElement;
import model.entity.LexemeType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * this interface defines functionality for lexeme factory with the aim of caching symbols
 */
public class LexemeFactoryImpl implements LexemeFactory {
    private static LexemeFactoryImpl instance;
    private Map<LexemeType, Map<Character, LexemeElement>> elementCash;

    private LexemeFactoryImpl(){
        elementCash= new WeakHashMap<>();
    }

    public static synchronized LexemeFactory getInstance(){
        if(instance==null)
            instance = new LexemeFactoryImpl();
        return instance;
    }

    /**
     * if lexeme element is in the map, than it will be returned, else create new one
     * @param type type of lexeme
     * @param content content of lexeme
     * @return the composite for terminal lexeme
     */
    @Override
    public LexemeElement getElement(LexemeType type, char content) {
        Map<Character, LexemeElement> typeCash = elementCash.get(type);
        if(typeCash == null){
            typeCash = new HashMap<>();
            elementCash.put(type, typeCash);
        }
        LexemeElement element = typeCash.get(content);
        if(element == null){
            element = new LexemeElement(content, type);
            typeCash.put(content, element);
        }
        return element;
    }
}
