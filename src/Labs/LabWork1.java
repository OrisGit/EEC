package Labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oris on 15.03.2017.
 */
public class LabWork1  extends LabWork{

    /**
     * Индуктивность (L)
     */
    private double inductance;

    /**
     * Входное напряжение (U)
     */
    private double voltage;

    /**
     * Cопротивление резистора (R)
     */
    private double resistorResistance;

    /**
     * Сопротивление катушки (Rк)
     */
    private double coilResistance;

    /**
     * Частоты гармонического тока (f)
     */
    private double frequency[];

    /**
     * Значения для таблицы
     */
    private final String[] COLUMN_NAMES = new String[]{"U","f","xL","Zк","Zц","I","UR","Uk","φ"};

    public LabWork1() {
        this(0,0,0,0,new double[0]);
    }

    public LabWork1(double inductance, double voltage, double resistorResistance, double coilResistance, double frequency[]) {
        this.inductance = inductance;
        this.voltage = voltage;
        this.resistorResistance = resistorResistance;
        this.coilResistance = coilResistance;
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
            val[i][2] = reactangleInductance(inductance,angularFrequency(frequency[i]));
            val[i][3] = coilImpedance(coilResistance,val[i][2]);
            val[i][4] = circuitImpedance(resistorResistance,coilResistance,val[i][2]);
            val[i][5] = amperage(val[i][4],voltage);
            val[i][6] = resistanceVoltage(resistorResistance,val[i][5]);
            val[i][7] = coilVoltage(val[i][5],val[i][3]);
            val[i][8] = phaseAngle(val[i][2],resistorResistance,coilResistance);
        }
        values.addAll(Arrays.asList(toStringArray(val)));
        table = new Table(names,values);
    }
}
