package baseball.domain.numberbaseball.model;

import baseball.domain.numberbaseball.view.GameResult;

import java.util.List;

public abstract class Game {

    public abstract GameResult init(List<Integer> numbers);

    public abstract GameResult play(Object data);
}
