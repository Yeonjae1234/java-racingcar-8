package racingcar;

public class Car {
    private String name;
    private int score;

    public Car(String name) {
        this.name = name;
        score = 0;
    }

    @Override
    public String toString(){
        return name + ":" + score;
    }
}
