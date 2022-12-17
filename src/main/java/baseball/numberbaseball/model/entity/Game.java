package baseball.numberbaseball.model.entity;

import baseball.numberbaseball.global.GameResultType;
import baseball.numberbaseball.model.entity.vo.GameData;
import baseball.numberbaseball.model.entity.vo.GameResult;
import baseball.numberbaseball.util.RandomNumber;

import java.util.List;

public class Game {

    private static final int NUMBER_COUNT = 3;

    private final Player computer;

    public Game() {
        this.computer = new Player(RandomNumber.getThreeNumbers());
    }

    public GameResult play(GameData gameData) {
        Player user = new Player(gameData);
        int ballCount = countingBallCount(user);
        int strikeCount = countingStrikeCount(user);
        return new GameResult(getGameResultType(strikeCount), ballCount, strikeCount);
    }

    private GameResultType getGameResultType(int strikeCount) {
        if (strikeCount == NUMBER_COUNT) {
            return GameResultType.SUCCESS;
        }

        return GameResultType.FAIL;
    }

    private int countingStrikeCount(Player user) {
        List<Integer> userNumbers = user.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (equalsNumber(userNumbers.get(i), computerNumbers.get(i))) {
                ++strikeCount;
            }
        }

        return strikeCount;
    }

    private int countingBallCount(Player user) {
        List<Integer> userNumbers = user.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();
        int ballCount = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            for (int j = 0; j < NUMBER_COUNT; j++) {
                if (i == j) {
                    continue;
                }

                if (equalsNumber(userNumbers.get(i), computerNumbers.get(j))) {
                    ++ballCount;
                    break;
                }
            }
        }

        return ballCount;
    }

    private boolean equalsNumber(int number1, int number2) {
        return number1 == number2;
    }
}
