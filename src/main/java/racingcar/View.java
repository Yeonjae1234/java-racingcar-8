package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public String getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public String getRoundCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readLine();
    }

    public void printStatusHeader(){
        System.out.println("\n실행 결과");
    }

    public void printRaceStatus(ArrayList<CarDTO> carListDTO){
        for (CarDTO carDTO : carListDTO) {
            System.out.print(formatOutput(carDTO));
        }
        System.out.print("\n");
    }

    public String formatOutput(CarDTO carDTO) {
        StringBuilder sb = new StringBuilder();
        sb.append(carDTO.name()).append(" : ");
        for (int i = 0; i < carDTO.score(); i++) {
            sb.append("-");
        }
        sb.append("\n");
        return String.valueOf(sb);
    }


    public void printFinalResult(ArrayList<String> winnerNameList) {
        String result = "최종 우승자 : "+String.join(", ",winnerNameList);
        System.out.println(result);

    }
}
