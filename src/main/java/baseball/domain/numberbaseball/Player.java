package baseball.domain.numberbaseball;

import java.util.List;

public abstract class Player {

    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.size() > 3) {
            throw new IllegalArgumentException();
        }

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
