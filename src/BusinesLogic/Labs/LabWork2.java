package BusinesLogic.Labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by D on 19.03.2017.
 */
public class LabWork2  extends LabWork{

    /**
     * Электрическая ёмкость (C)
     */
    private double electricCapacitance;

    /**
     * Входное напряжение (U)
     */
    private double voltage;

    /**
     * Cопротивление резистора (R)
     */
    private double resistorResistance;

    /**
     * Частоты гармонического тока (f)
     */
    private double frequency[];

    /**
     * Значения для таблицы
     */
    private final String[] COLUMN_NAMES = new String[]{"U","f","xC","Z","I","UR","Uc","φ"};

    public LabWork2() { this(0,0,0,new double[0]);}

    public LabWork2(double electricCapacitance, double voltage, double resistorResistance, double frequency[]) {
        this.electricCapacitance = electricCapacitance;
        this.voltage = voltage;
        this.resistorResistance = resistorResistance;
        this.frequency = frequency;
        createTable();
    }

    @Override
    public Table getTable() {
        return table;
    }

    @Override
    void createTable() {
        List<String> names = new ArrayList<>(Arrays.asList(COLUMN_NAMES));
        List<String[]> values = new ArrayList<>();
        double[][] val = new double[frequency.length][COLUMN_NAMES.length];
        for(int i=0;i<frequency.length;i++){
            val[i][0] = voltage;
            val[i][1] = frequency[i];
            val[i][2] = reactangleСapacitance(electricCapacitance,angularFrequency(frequency[i]));
            val[i][3] = circuitImpedanceLab2(resistorResistance,val[i][2]);
            val[i][4] = amperage(val[i][3],voltage);
            val[i][5] = resistanceVoltage(resistorResistance,val[i][4]);
            val[i][6] = condenserVoltage(val[i][4],val[i][2]);
            val[i][7] = phaseAngleLab2(val[i][2],resistorResistance);
        }
        values.addAll(Arrays.asList(toStringArray(val)));
        table = new Table(names,values);
    }
}