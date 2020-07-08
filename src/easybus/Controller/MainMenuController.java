package easybus.Controller;

import easybus.View.InsertMenu;
import easybus.View.MainMenu;
import easybus.View.ViewMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainMenuController
{
    private DataController model;
    private MainMenu view;
    private String UID;

    public MainMenuController(DataController model, MainMenu view, String str){
        this.model = model;
        this.view = view;

        initViewActionListeners();
    }

    private void initViewActionListeners() {
        view.initButtons(new CloseListener());
    }

    public class CloseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();

            changeWorkingSet();
            if(command.equals("Insert"))  {
                InsertMenu insertMenu = new InsertMenu();
                InsertController controller = new InsertController(model, insertMenu);
            } else if(command.equals("View"))  {
                ViewMenu viewMenu = new ViewMenu();
                ViewController controller = new ViewController(model, viewMenu);
            }
        }
    }

    private void changeWorkingSet() {
        int index = Arrays.asList(view.getOptionList()).indexOf((String) view.getOptionsList().getSelectedItem());
        switch(index) {
            case 0:
                model.setSelected(DataController.OPTIONS.CAR);
                break;
            case 1:
                model.setSelected(DataController.OPTIONS.STATION);
                break;
            case 2:
                model.setSelected(DataController.OPTIONS.ROUTE);
                break;
            case 3:
                model.setSelected(DataController.OPTIONS.PASSENGER);
                break;
            case 4:
                model.setSelected(DataController.OPTIONS. WORKER);
                break;
        }
    }
}
