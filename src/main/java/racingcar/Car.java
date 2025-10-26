package racingcar;

public class Car {
    private String name;
    private int score;

    public Car(String name) {
        this.name = name;
        score = 0;
    }

    public void plusScore(){
        score++;
    }

    public CarDTO createCarDTO(){
        return new CarDTO(this.name, this.score);
    }

    @Override
    public String toString(){
        return name + ":" + score;
    }
}
