package BusinesLogic.Labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oris on 15.03.2017.
 */
public class Table {

    /**
     * Массив значений
     */
    private List<String[]> values = new ArrayList<>();

    /**
     * Массив имён столбцов
     */
    private List<String> names = new ArrayList<>();

    public Table(){
    }

    public Table(List<String> names, List<String[]> values){
        this.names.addAll(names);
        this.values.addAll(values);
    }

    public void AddColumn(String name, String[] values){
        this.names.add(name);
        this.values.add(values);
    }

    public List<String[]> getValues() {
        return values;
    }

    public void setValues(List<String[]> values) {
        this.values = values;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

}
