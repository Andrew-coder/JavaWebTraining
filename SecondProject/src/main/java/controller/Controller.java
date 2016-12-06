package controller;

import model.Model;
import model.dao.SentenceDao;
import model.dao.TextDao;
import model.dao.WordDao;
import model.dao.impl.files.DaoFactory;
import model.dao.impl.files.TextDaoImpl;
import model.entity.Sentence;
import model.entity.Text;
import view.View;

/**
 * Created by andri on 12/4/2016.
 */
public class Controller {
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
    }

    /**
     * the method which sets the sequence of calls in program
     */
    public void processUser() {
        TextDao textDao = DaoFactory.getInstance().getTextDao();
        SentenceDao sentenceDao = DaoFactory.getInstance().getSentenceDao();
        Text text =new Text(sentenceDao.getSentencesFromText(
                textDao.getWholeText()));
        model.setText(text);
        view.printMessage(model.getTextComposite().toString());
        view.printMessage(View.SUCCESFULL_PARSE);
        String uniqueWord = model.findUniqueWord(text);
        if(uniqueWord!= null) {
            view.printMessage(uniqueWord);
        }
        else view.printMessage(View.UNIQUE_WORD_NOT_FOUND);
    }
}
