package baseball.domain.numberbaseball;

import java.util.List;

public abstract class Player {

    private List<Integer> numbers;

    public Player() {}

    public Player(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.size() > 3) {
            throw new IllegalArgumentException();
        }

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void changeNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
