package controller;

import model.Model;
import model.dao.LexemeDao;
import model.dao.TextDao;
import model.dao.impl.files.DaoFactory;
import model.entity.LexemeContainer;
import model.entity.LexemeType;
import view.View;

/**
 * Created by andri on 12/4/2016.
 */
public class Controller {
    /**
     * instance of dao factory
     */
    DaoFactory factory;
    /**
     * the instance of model where stores all business logic
     */
    private Model model;
    /**
     * the instance of view where implements the work with console
     */
    private View view;

    /**
     * constructor, where initialize the model and view
     * @param model the instance of model
     * @param view the instance of view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        factory = DaoFactory.getInstance();
    }

    /**
     * the method which sets the sequence of calls in program
     */
    public void processUser() {
        TextDao textDao = factory.getTextDao();
        LexemeDao lexemeDao = factory.getLexemeDao();
        String text = textDao.getWholeText();
        model.setContainer( lexemeDao.getAllLexems(text));
        view.printMessage(model.getContainer().toString());
        view.printMessage(View.SUCCESFULL_PARSE);
        String uniqueWord = model.findUniqueWord();
        if(uniqueWord!= null) {
            view.printMessage(uniqueWord);
        }
        else view.printMessage(View.UNIQUE_WORD_NOT_FOUND);
    }
}
