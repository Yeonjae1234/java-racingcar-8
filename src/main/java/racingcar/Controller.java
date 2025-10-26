package racingcar;

import java.util.ArrayList;

public class Controller {
    View view;
    Validator validator;
    OutputPort outputPort;

    public Controller(View view, Validator validator, OutputPort outputPort) {
        this.view = view;
        this.validator = validator;
        this.outputPort = outputPort;
    }

    public void run(){
        String[] carNameList = validator.validateCarName(view.getCarName());
        CarList carList = new CarList(carNameList);
        int roundCount = validator.validateRoundCount(view.getRoundCount());
        Game game = new Game(carList, roundCount);
        GameService gameService = new GameService(game, outputPort);
        view.printStatusHeader();
        gameService.runGame();
        ArrayList<CarDTO> carDTOS = carList.printCurrentStatus();
        view.printFinalResult(gameService.findWinnerList(carDTOS));
    }
}
