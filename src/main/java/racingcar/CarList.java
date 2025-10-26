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

    public int getCarNumber(){
        return carNumber;
    }

    public void moveForward(int currentCarIndex) {
        carArrayList.get(currentCarIndex).plusScore();
    }

    public ArrayList<CarDTO> printCurrentStatus(){
        ArrayList<CarDTO> carListDTO = new ArrayList<>();
        for (Car car : carArrayList) {
            carListDTO.add(car.createCarDTO());
        }
        return carListDTO;
    }

    @Override
    public String toString(){
        return carArrayList.toString();
    }

}
