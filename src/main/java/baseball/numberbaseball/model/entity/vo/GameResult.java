package baseball.numberbaseball.model.entity.vo;

import baseball.numberbaseball.global.GameResultType;

public class GameResult {

    private final GameResultType gameResultType;

    private final int ballCount;

    private final int strikeCount;

    public GameResult(GameResultType gameResultType, int ballCount, int strikeCount) {
        this.gameResultType = gameResultType;
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public GameResultType getGameResultType() {
        return gameResultType;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
