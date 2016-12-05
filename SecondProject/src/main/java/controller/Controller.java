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
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        TextDao textDao = DaoFactory.getInstance().getTextDao();
        SentenceDao sentenceDao = DaoFactory.getInstance().getSentenceDao();
        Text text =new Text(sentenceDao.getSentencesFromText(
                textDao.getWholeText()));
        model.setText(text);
        view.printMessage(model.getTextComposite().toString());
        view.printMessage(View.SUCCESFULL_PARSE);
        view.printMessage(model.findUniqueWord(text));
    }
}
