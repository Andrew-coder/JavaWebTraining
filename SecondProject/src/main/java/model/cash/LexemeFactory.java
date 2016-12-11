package model.cash;

import model.entity.Lexeme;
import model.entity.LexemeContainer;
import model.entity.LexemeElement;
import model.entity.LexemeType;

import java.util.List;

/**
 * Created by andri on 12/11/2016.
 */
public interface LexemeFactory {
    LexemeElement getElement(LexemeType type, char content);
}
