import controller.Controller;
import model.Model;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import view.View;

import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TestController {
    @Mock
    private Model model;
    @Mock
    private View view;
    @Mock
    private InputStream inputStream;

    private Controller controller;
    private Controller spyController;

    @Before
    public void init(){
        controller = new Controller(model, view);
        spyController = spy(controller);

    }

    @Test
    public void testProcessUser(){
        doReturn(20).when(spyController).inputIntValueWithScanner(inputStream);
        doReturn(10).when(spyController).inputIntValueWithScanner(inputStream);
        doNothing().when(spyController).guessingProcess(inputStream);
        doNothing().when(model).setRange(anyInt(), anyInt());
        spyController.processUser();
        verify(spyController, times(2)).inputIntValueWithScanner(inputStream);
    }

    @Test
    public void testGuessingProcess(){
        int []attempts= {40,20,10,30,50,60,70};
        doNothing().when(model).addToStatistic(anyInt());
        doNothing().when(view).printMessage(anyString());
        when(model.checkNumber(50)).thenReturn(true);
        model.setGuessValue(50);
        int i=0;
        boolean token = false;
        do{
            token =model.checkNumber(attempts[i]);
            ++i;
        }while (!token);
        verify(model, times(5)).checkNumber(anyInt());
    }

}
