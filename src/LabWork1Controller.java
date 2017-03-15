import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;




/**
 * Created by Oris on 15.03.2017.
 */
public class LabWork1Controller {
    @FXML
    private TextField tf_voltage;

    @FXML
    private TextField tf_frequency;

    @FXML
    private TextField tf_inductance;

    @FXML
    private TextField tf_resistorResistance;

    @FXML
    private TextField tf_coillResistance;

    @FXML
    private Button btn_addFrequency;

    @FXML
    private Button btn_deleteFrequency;

    @FXML
    private Button btn_calculate;

    @FXML
    private ListView lv_frequencies;

    private MainForm mainForm;

    public LabWork1Controller(){

    }

    @FXML
    private void initialize(){
//        ListProperty<String> listProperty  = new SimpleListProperty<String>();
//        listProperty..setAll("12","22");
//        lv_frequencies.itemsProperty().bind();
    }

    public void setMainForm(MainForm mainForm){
        this.mainForm = mainForm;
    }
}
