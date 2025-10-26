package racingcar;

import java.util.ArrayList;

public class CarList {
    private ArrayList<Car> carArrayList;
    private int carNumber;

    public CarList(String[] carList) {
        carArrayList = new ArrayList<>();
        for (String string : carList) {
            carArrayList.add(new Car(string));
        }
        carNumber = carList.length;
    }

    @Override
    public String toString(){
        return carArrayList.toString();
    }

}
