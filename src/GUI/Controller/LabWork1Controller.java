package GUI.Controller;


import BusinesLogic.Labs.LabWork1;
import BusinesLogic.Labs.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oris on 15.03.2017.
 */
public class LabWork1Controller {

    @FXML
    private TextField tf_coilResistance;

    @FXML
    private Button btn_сalculate;

    @FXML
    private TextField tf_voltage;

    @FXML
    private TextField tf_frequency;

    @FXML
    private TextField tf_inductance;

    @FXML
    private TextField tf_resistorResistance;


    @FXML
    private Button btn_addFrequency;

    @FXML
    private Button btn_deleteFrequency;

    @FXML
    private ListView lv_frequencies;

    @FXML
    private TableView tv_results;

    private List<TableColumn<Map,String>> tableColumns = new ArrayList<>();


    public LabWork1Controller(){

    }

    @FXML
    private void initialize(){
        lv_frequencies.setItems(FXCollections.observableArrayList("2000","6000","10000","14000","18000"));
        btn_addFrequency.setOnAction(event -> click_addFrequency());
        btn_deleteFrequency.setOnAction(event -> click_deleteFrequency());
        btn_сalculate.setOnAction(event -> click_calculate());
    }

    private void click_addFrequency(){
        if(isNumber(tf_frequency.getText())){
           lv_frequencies.getItems().add(tf_frequency.getText());
        }
        else {
            Alert d = new Alert(Alert.AlertType.ERROR);
            d.setContentText("Введите число!");
            d.setTitle("Ошибка!");
            d.showAndWait();
        }


    }

    private void click_deleteFrequency(){
        try{
            lv_frequencies.getItems().remove(lv_frequencies.getSelectionModel().getSelectedIndex());
        }
        catch (IndexOutOfBoundsException e)
        {

        }

    }

    private void click_calculate(){
        if(isNumber(tf_coilResistance.getText()) && isNumber(tf_inductance.getText()) &&
                isNumber(tf_resistorResistance.getText()) && isNumber(tf_voltage.getText())){


            LabWork1 lb = new LabWork1(Double.parseDouble(tf_inductance.getText()),
                    Double.parseDouble(tf_voltage.getText()), Double.parseDouble(tf_resistorResistance.getText()),
                    Double.parseDouble(tf_coilResistance.getText()),toDouble(lv_frequencies.getItems().toArray()));

            setDataInTable(lb.getTable());

        }

    }

    private void setDataInTable(Table data){


        for (int i=0;i<data.getNames().size();i++) {
            tableColumns.add(new TableColumn<>(data.getNames().get(i)));
            tableColumns.get(i).setCellValueFactory(new MapValueFactory<>(data.getNames().get(i)));
        }
        tv_results.setItems(generateDataInMap(data));
        tv_results.getColumns().setAll(tableColumns);


    }

    private ObservableList<Map> generateDataInMap(Table data) {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for(int i=0; i<data.getValues().size();i++){
            Map<String, String> dataRow = new HashMap<>();
            for(int j=0; j<data.getNames().size();j++){
                dataRow.put(data.getNames().get(j), data.getValues().get(i)[j]);
            }
            allData.add(dataRow);
        }
        return allData;
    }

    private double[] toDouble(Object[] array){
        double[] newArr = new double[array.length];
            for (int i = 0; i<array.length;i++){
                newArr[i] = Double.parseDouble(array[i].toString());
            }
            return newArr;
    }

    private boolean isNumber(String text){
        if(text.matches("([0-9]+(.[0-9]+)?)")){
            return true;
        }
        return false;
    }

}
