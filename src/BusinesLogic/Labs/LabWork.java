package BusinesLogic.Labs;

/**
 * Created by Oris on 15.03.2017.
 */
abstract public class LabWork {

    /**
     * Таблица создаётся один раз при создании класса
     */
    protected Table table;

    /**
     * Возвращает полное сопротивление цепи (Zц)
     * @param resistorResistance - сопротивление резистора (R)
     * @param coilResistance - сопротивление катушки (Rк)
     * @param reactanceInductance - реактивное сопротивление индуктивности (xL)
     */
    public double circuitImpedance(double resistorResistance, double coilResistance, double reactanceInductance){
        return Math.sqrt(Math.pow(resistorResistance+coilResistance,2)+Math.pow(reactanceInductance,2));
    }

    /**
     * Возвращает реактивное сопротивление индуктивности (xL)
     * @param inductance - индуктивность (L)
     * @param angularFrequency - угловая частота гармонического тока (ω)
     */
    public double reactangleInductance(double inductance, double angularFrequency){
        return inductance*angularFrequency;
    }

    /**
     * Возвращает угловую частоту гармонического тока (ω)
     * @param frequency - частота гармонического тока (f)
     */
    public double angularFrequency(double frequency){
        return 2*Math.PI*frequency;
    }

    /**
     * Возвращает силу тока (I)
     * @param circuitImpedance - полное сопротивление цепи (Zц)
     * @param voltage - входное напряжение (U)
     */
    public double amperage(double circuitImpedance, double voltage){
        return voltage/circuitImpedance;
    }

    /**
     * Возвращает полное сопротивление катушки индуктивности (Zк)
     * @param coilResistance - сопротивление катушки (Rк)
     * @param reactangleResistance - реактивное сопротивление индуктивности (xL)
     */
    public double coilImpedance(double coilResistance, double reactangleResistance){
        return Math.sqrt(Math.pow(coilResistance,2)+Math.pow(reactangleResistance,2));
    }

    /**
     * Возвращает действующее напряжение катушки индуктивности (Uк)
     * @param amperage - сила тока (I)
     * @param coilImpedance - полное сопротивление катушки индуктивности (Zк)
     */
    public double coilVoltage(double amperage, double coilImpedance){
        return amperage*coilImpedance;
    }

    /**
     * Возвращает действующее напряжение резистора (UR)
     * @param resistorResistance - сопротивление резистора (R)
     * @param amperage - сила тока (I)
     */
    public double resistanceVoltage(double resistorResistance, double amperage){
        return amperage*resistorResistance;
    }

    /**
     * Возвращает угол сдвига по фазе между входным напряжением u(t) и током i(t). (φ)
     * @param reactangleInductance - реактивное сопротивление индуктивности (xL)
     * @param resistorResistance - сопротивление резистора (R)
     * @param coilResistance - сопротивление катушки (Rк)
     */
    public double phaseAngle(double reactangleInductance, double resistorResistance, double coilResistance){
        return Math.atan2(reactangleInductance,resistorResistance+coilResistance);
    }

    /**
     * Возвращает реактивное сопротивление емкости (xC)
     * @param electricCapacitance - Электрическая ёмкость (C)
     * @param angularFrequency - угловая частота гармонического тока (ω)
     */
    public double reactangleСapacitance(double electricCapacitance, double angularFrequency){
        return 1/(electricCapacitance*angularFrequency);
    }

    /**
     * Возвращает полное сопротивление цепи (Z)
     * @param resistorResistance - сопротивление резистора (R)
     * @param reactanceСapacitance - реактивное сопротивление емкости (xC)
     */
    public double circuitImpedanceLab2(double resistorResistance, double reactanceСapacitance){
        return Math.sqrt(Math.pow(resistorResistance,2)+Math.pow(reactanceСapacitance,2));
    }

    /**
     * Возвращает действующее напряжение конденсатора (Uc)
     * @param amperage - сила тока (I)
     * @param reactanceСapacitance - реактивное сопротивление емкости (xC)
     */
    public double condenserVoltage(double amperage, double reactanceСapacitance){
        return amperage*reactanceСapacitance;
    }

    /**
     * Возвращает угол сдвига по фазе между входным напряжением u(t) и током i(t) для второй лабы. (φ)
     * @param reactanceСapacitance - реактивное сопротивление емкости (xC)
     * @param resistorResistance - сопротивление резистора (R)
     */
    public double phaseAngleLab2(double reactanceСapacitance, double resistorResistance){
        return Math.atan2(-reactanceСapacitance,resistorResistance);
    }

    /**
     * Возвращает таблицу для вывода
     */
    abstract Table getTable();

    /**
     * Создаёт таблицу и записывает её в переменную Table
     */
    abstract void createTable();

    /**
     * Преобразует массив Double в массив String
     * @param array - преобразуемый массив
     */
    protected String[][] toStringArray(double[][] array){
        String[][] newArr = new String[array.length][array[0].length];
        for (int i = 0; i<array.length;i++){
            for (int j = 0; j<array[i].length; j++){
                newArr[i][j] = String.valueOf(array[i][j]);
            }
        }
        return newArr;
    }
}
