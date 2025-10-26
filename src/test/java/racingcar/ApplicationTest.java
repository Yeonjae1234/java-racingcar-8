package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    View view = new View();
    Validator validator = new Validator();

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
