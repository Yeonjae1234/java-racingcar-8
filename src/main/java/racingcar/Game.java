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

    @Override
    public String toString(){
        return carList.toString() + "," + roundCount + "," + currentRound;
    }
}
