package racingcar;

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

    @Override
    public String toString(){
        return carList.toString() + "," + roundCount + "," + currentRound;
    }
}
