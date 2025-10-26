package racingcar;

public class Controller {
    View view;
    Validator validator;

    public Controller(View view, Validator validator) {
        this.view = view;
        this.validator = validator;
    }

    public void run(){
        String[] carNameList = validator.validateCarName(view.getCarName());
        CarList carList = new CarList(carNameList);
        int roundCount = validator.validateRoundCount(view.getRoundCount());
        Game game = new Game(carList, roundCount);
    }
}
