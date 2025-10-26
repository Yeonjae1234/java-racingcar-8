package racingcar;

public class AppConfig {

    final View view = new View();

    public OutputPort outputPort(){
        return new OutputPort(view);
    }

    public Controller controller(){
        return new Controller(view, new Validator(), outputPort());
    }
}
