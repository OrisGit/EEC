package GUI.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Oris on 15.03.2017.
 */
public class RootLayoutController extends Controller{
    @FXML
    private MenuItem mi_oscilloscope;

    @FXML
    private void initialize(){
        mi_oscilloscope.setOnAction(event -> click_oscilloscope());
    }

    private void click_oscilloscope(){
        try {
            FXMLLoader loader = new FXMLLoader();
            BorderPane root = loader.load(getClass().getClassLoader().getResource("GUI/View/OscilloscopeLayout.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
