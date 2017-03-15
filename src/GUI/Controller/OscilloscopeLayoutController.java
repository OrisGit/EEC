package GUI.Controller;

import BusinesLogic.Utils.Oscilloscope;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sun.nio.cs.Surrogate;


/**
 * Created by Oris on 16.03.2017.
 */
public class OscilloscopeLayoutController extends Controller{

    @FXML
    private TextField tf_sweepHorizontalValue;
    @FXML
    private TextField tf_sweepVerticalValue;
    @FXML
    private TextField tf_numberOfDivisionsToMax;
    @FXML
    private TextField tf_numberOfDivisionsInPeriod;
    @FXML
    private TextField tf_voltage;
    @FXML
    private TextField tf_frequency;
    @FXML
    private TextField tf_numberOfDivisionsBetweenBeginningsPeriods;
    @FXML
    private TextField tf_phaseShift;
    @FXML
    private Button btn_calculate;

    @FXML
    private void initialize(){
        btn_calculate.setOnAction(event -> click_calculate());
    }

    private void click_calculate() {
        if(isNumber(tf_sweepHorizontalValue.getText())&&isNumber(tf_sweepVerticalValue.getText())&&
                isNumber(tf_numberOfDivisionsBetweenBeginningsPeriods.getText())&& isNumber(tf_numberOfDivisionsInPeriod.getText())&&
                isNumber(tf_numberOfDivisionsToMax.getText())){
            Oscilloscope oscilloscope = new Oscilloscope(Double.valueOf(tf_sweepHorizontalValue.getText()),Double.valueOf(tf_sweepVerticalValue.getText()));
            tf_phaseShift.setText(String.valueOf(oscilloscope.phaseShift(Double.valueOf(tf_numberOfDivisionsInPeriod.getText()),Double.valueOf(tf_numberOfDivisionsBetweenBeginningsPeriods.getText()))));
            tf_frequency.setText(String.valueOf(oscilloscope.frequency(Double.valueOf(tf_numberOfDivisionsInPeriod.getText()))));
            tf_voltage.setText(String.valueOf(oscilloscope.voltage(Double.valueOf(tf_numberOfDivisionsToMax.getText()))));
        }
    }
}
