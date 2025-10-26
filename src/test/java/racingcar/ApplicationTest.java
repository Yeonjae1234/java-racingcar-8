package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    View view = new View();
    Validator validator = new Validator();
    OutputPort outputPort = new OutputPort(view);


    @Test
    void validateCarName(){
        assertSimpleTest(() -> {
            String TestInput = "pobi,woni,jun\n";
            System.setIn(new ByteArrayInputStream(TestInput.getBytes()));
            String test = view.getCarName();
            assertThat(validator.validateCarName(test)).containsExactly("pobi", "woni", "jun");
        });
    }


    @Test
    void getRoundCount(){
        assertSimpleTest(() -> {
            String TestInput = "5\n";
            System.setIn(new ByteArrayInputStream(TestInput.getBytes()));
            String test = view.getRoundCount();
            assertThat(validator.validateRoundCount(test)).isEqualTo(5);
        });
    }

    @Test
    void makeCarList(){
        assertSimpleTest(() -> {
            String[] nameList = {"pobi", "woni", "jun"};
            CarList carList = new CarList(nameList);
            assertThat(carList.toString()).isEqualTo("[pobi:0, woni:0, jun:0]");
        });
    }

    @Test
    void makeGame(){
        assertSimpleTest(() -> {
            String[] nameList = {"pobi", "woni", "jun"};
            CarList carList = new CarList(nameList);
            Game game = new Game(carList, 5);
            assertThat(game.toString()).isEqualTo("[pobi:0, woni:0, jun:0],5,0");
        });
    }

    @Test
    void proceedRoundTrue(){
        assertSimpleTest(() -> {
            String[] nameList = {"pobi", "woni"};
            CarList carList = new CarList(nameList);
            Game game = new Game(carList, 1);
            GameService gameService = new GameService(game,outputPort);
            gameService.proceedRound(true);
            assertThat(game.toString()).isEqualTo("[pobi:1, woni:1],1,0");
        });
    }

    @Test
    void proceedRoundFalse(){
        assertSimpleTest(() -> {
            String[] nameList = {"pobi", "woni"};
            CarList carList = new CarList(nameList);
            Game game = new Game(carList, 1);
            GameService gameService = new GameService(game,outputPort);
            gameService.proceedRound(false);
            assertThat(game.toString()).isEqualTo("[pobi:0, woni:0],1,0");
        });
    }

    @Test
    void runGameTrue(){
        assertSimpleTest(() -> {
            String[] nameList = {"pobi", "woni"};
            CarList carList = new CarList(nameList);
            Game game = new Game(carList, 2);
            GameService gameService = new GameService(game,outputPort);
            gameService.runGame();
            assertThat(game.toString()).isEqualTo("[pobi:2, woni:2],2,3");
        });
    }

    @Test
    void makeCarListDTO(){
        assertSimpleTest(() -> {
            String[] nameList = {"pobi", "woni"};
            CarList carList = new CarList(nameList);
            Game game = new Game(carList, 2);
            GameService gameService = new GameService(game,outputPort);
            gameService.runGame();
            assertThat(game.printCurrentStatus())
                    .extracting(CarDTO::name,CarDTO::score)
                    .containsExactly(
                            tuple("pobi",2),
                            tuple("woni",2)
                    );
        });
    }

//
//
//    @Test
//    void 기능_테스트() {
//        assertRandomNumberInRangeTest(
//            () -> {
//                run("pobi,woni", "1");
//                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
//            },
//            MOVING_FORWARD, STOP
//        );
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
//                .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
