package racingcar;

public class Validator {
    public String[] validateCarName(String userInput) {
        try{
            return userInput.split(",");
        }catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int validateRoundCount(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
