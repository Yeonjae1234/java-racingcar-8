package racingcar;

import java.util.ArrayList;

public class Game {
    private CarList carList;
    private int roundCount;
    private int currentRound;

    public Game(CarList carList, int roundCount) {
        this.carList = carList;
        this.roundCount = roundCount;
        currentRound = 0;
    }

    public boolean checkRemainRound(){
        currentRound++;
        if (currentRound > roundCount) {
            return false;
        }
        return true;
    }

    public boolean hasNextCar(int currentCarIndex){
        if(currentCarIndex<carList.getCarNumber()){
            return true;
        }
        return false;
    }

    public void moveForward(int currentCarIndex){
        carList.moveForward(currentCarIndex);
    }

    public ArrayList<CarDTO> printCurrentStatus(){
        return carList.printCurrentStatus();
    }

    public ArrayList<String> findWinner(ArrayList<CarDTO> carDTOS){
        int maxScore = findMaxScore(carDTOS);
        ArrayList<String> winnerNameList = new ArrayList<>();
        for (CarDTO car : carDTOS) {
           addWinnerName(car,maxScore,winnerNameList);
        }
        return winnerNameList;
    }

    public int findMaxScore(ArrayList<CarDTO> carDTOS){
        int maxScore = 0;
        for (CarDTO car : carDTOS) {
            maxScore = Math.max(maxScore, car.score());
        }
        return maxScore;
    }

    public void addWinnerName(CarDTO car, int maxScore, ArrayList<String> winnerNameList) {
        if (car.score() == maxScore) {
            winnerNameList.add(car.name());
        }
    }

    @Override
    public String toString(){
        return carList.toString() + "," + roundCount + "," + currentRound;
    }
}
