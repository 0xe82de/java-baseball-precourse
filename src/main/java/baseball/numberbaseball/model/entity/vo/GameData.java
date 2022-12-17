package baseball.numberbaseball.model.entity.vo;

import java.util.List;

public class GameData {

    private final List<Integer> numbers;

    public GameData(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
