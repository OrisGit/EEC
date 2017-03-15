package GUI.Controller;

/**
 * Created by Oris on 16.03.2017.
 */
public abstract class Controller {
    protected double[] toDouble(Object[] array){
        double[] newArr = new double[array.length];
        for (int i = 0; i<array.length;i++){
            newArr[i] = Double.parseDouble(array[i].toString());
        }
        return newArr;
    }

    protected boolean isNumber(String text){
        if(text.matches("([0-9]+(.[0-9]+)?)")){
            return true;
        }
        return false;
    }
}
