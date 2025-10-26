package racingcar;

public class Validator {
    public String[] validateCarName(String userInput) {
        try{
            return userInput.split(",");
        }catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
