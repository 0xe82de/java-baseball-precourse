package baseball.domain.numberbaseball.model;

import java.util.List;

public abstract class Player {

    protected List<Integer> numbers;

    public Player() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void changeNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
