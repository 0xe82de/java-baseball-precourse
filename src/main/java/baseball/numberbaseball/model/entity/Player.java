package baseball.numberbaseball.model.entity;

import baseball.numberbaseball.model.entity.vo.GameData;

import java.util.List;

public class Player {

    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Player(GameData gameData) {
        this(gameData.getNumbers());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
