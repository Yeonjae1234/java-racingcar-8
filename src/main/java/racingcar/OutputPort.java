package racingcar;

import java.util.ArrayList;

public class OutputPort {
    View view;

    public OutputPort(View view) {
        this.view = view;
    }

    public void printRaceStatus(ArrayList<CarDTO> carListDTO){
        view.printRaceStatus(carListDTO);
    }
}
