package racingcar;

public class Validator {
    public String[] validateCarName(String userInput) {
        try{
            String[] nameList = userInput.split(",");
            if(!checkNameLength(nameList)){
                throw new IllegalArgumentException();
            }
            return nameList;
        }catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkNameLength(String[] nameList) {
        for (String name : nameList) {
            if(name.length()>5) return false;
            if(name.isEmpty()) return false;
        }
        return true;
    }

    public int validateRoundCount(String userInput) {
        try {
            int roundCount = Integer.parseInt(userInput);
            if(roundCount<0) throw new IllegalArgumentException();
            return roundCount;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
