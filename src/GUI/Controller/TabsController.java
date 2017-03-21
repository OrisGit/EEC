package GUI.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Created by Oris on 21.03.2017.
 */
public class TabsController extends Controller {

    @FXML
    private Tab lab1;

    @FXML
    private Tab lab2;

    @FXML
    private Tab results;

    @FXML
    private TableView tableView;

    private Tab[] tabs;

    private final int LAB_WORK_COUNT = 2;

    public TabsController(){

    }

    @FXML
    private void initialize(){
        tabs = new Tab[]{lab1, lab2};
        showLabWorks();
    }


    private void showLabWorks() {
        FXMLLoader loader;
        HBox content;
        LabWorkController c;
        for(int i=1;i<=LAB_WORK_COUNT;i++){
            try {
                loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("GUI/View/LabWork"+i+"Layout.fxml"));
                content = (HBox)loader.load();
                c = loader.getController();
                c.setTableView(tableView);
                tabs[i-1].setContent(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
