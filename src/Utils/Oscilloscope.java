package Utils;

/**
 * Created by Oris on 15.03.2017.
 */
public class Oscilloscope {
    /**
     * Значение горизонтальной развёртки (секунды)
     */
    private double sweepHorizontalValue;

    /**
     * Значение вертикальной развёртки (Вольты)
     */
    private double sweepVerticalValue;

    public Oscilloscope(){
        this(1,1);
    }

    public Oscilloscope(double sweepHorizontalValue,double sweepVerticalValue){
        this.sweepHorizontalValue = sweepHorizontalValue;
        this.sweepVerticalValue = sweepVerticalValue;
    }

    /**
     * Возвращает измеряемое напряжение в Вольтах
     * @param numberOfDivisions - количество клеток и их долей от центра амплитуды до максимума
     */
    public double voltage(double numberOfDivisions){
        return numberOfDivisions*sweepVerticalValue;
    }

    /**
     * Возвращает измеряемую частоту в Герцах
     * @param numberOfDivisionsInPeriod - число делений сетки, занимаемых одним периодом сигнала
     */
    public double frequency(double numberOfDivisionsInPeriod){
        return 1.0/(numberOfDivisionsInPeriod*sweepHorizontalValue);
    }

    /**
     * Возвращает модуль сдвига фаз в градусах
     * @param numberOfDivisionsInPeriod - число делений сетки, занимаемых одним периодом сигнала
     * @param numberOfDivisionsBetweenBeginningsPeriods - число делений сетки между началами периодов
     */
    public double phaseShift(double numberOfDivisionsInPeriod, double numberOfDivisionsBetweenBeginningsPeriods){
        return (360*numberOfDivisionsBetweenBeginningsPeriods)/numberOfDivisionsInPeriod;
    }


}
