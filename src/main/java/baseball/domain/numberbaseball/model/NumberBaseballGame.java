package baseball.domain.numberbaseball.model;

import baseball.domain.numberbaseball.util.NumberVerifier;
import baseball.domain.numberbaseball.view.GameResult;
import baseball.domain.numberbaseball.view.GameResultType;
import baseball.domain.numberbaseball.view.NumberBaseballGameResult;

import java.util.List;

public class NumberBaseballGame extends Game {

    private static final int NUMBER_COUNT = 3;

    private Player user;

    private Player computer;

    @Override
    public GameResult init(List<Integer> numbers) {
        user = new User();
        computer = new Computer(numbers);
        return new NumberBaseballGameResult(GameResultType.INIT, null, null);
    }

    @Override
    public GameResult play(Object data) {
        return play((List<Integer>) data);
    }

    private GameResult play(List<Integer> numbers) {
        NumberVerifier.verify(numbers);

        user.changeNumbers(numbers);

        List<Integer> userNumbers = user.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();
        int ballCount = calcBallCount(userNumbers, computerNumbers);
        int strikeCount = calcStrikeCount(userNumbers, computerNumbers);

        GameResultType gameResultType = strikeCount == NUMBER_COUNT ? GameResultType.SUCCESS : GameResultType.FAIL;
        return new NumberBaseballGameResult(gameResultType, ballCount, strikeCount);
    }

    private int calcStrikeCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (userNumbers.get(i) == computerNumbers.get(i)) {
                ++strikeCount;
            }
        }

        return strikeCount;
    }

    private int calcBallCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            for (int j = 0; j < NUMBER_COUNT; j++) {
                if (i == j) {
                    continue;
                }

                if (userNumbers.get(i) == computerNumbers.get(j)) {
                    ++ballCount;
                    break;
                }
            }
        }

        return ballCount;
    }
}
