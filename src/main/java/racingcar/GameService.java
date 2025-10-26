package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {
    Game game;
    OutputPort outputPort;

    public GameService(Game game,OutputPort outputPort) {
        this.game = game;
        this.outputPort = outputPort;
    }

    public void runGame(){
        while(game.checkRemainRound()){
            proceedRound(true);
            outputPort.printRaceStatus(game.printCurrentStatus());
        }
    }

    public void proceedRound(boolean movingResult){
        int currentCarIndex = 0;
        while(game.hasNextCar(currentCarIndex)){
            // movingResult = decideMoving();
            if (!movingResult) return;
            game.moveForward(currentCarIndex++);
        }
    }

    public boolean decideMoving(){
        int result = pickNumberInRange(0,9);
        if (result >= 4) {
            return true;
        }
        return false;
    }

}
