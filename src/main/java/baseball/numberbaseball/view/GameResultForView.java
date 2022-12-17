package baseball.numberbaseball.view;

import baseball.numberbaseball.global.GameResultType;

public class GameResultForView {

    private final GameResultType gameResultType;

    private final int ballCount;

    private final int strikeCount;

    public GameResultForView(GameResultType gameResultType, int ballCount, int strikeCount) {
        this.gameResultType = gameResultType;
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean userWin() {
        return gameResultType == GameResultType.SUCCESS;
    }

    public boolean userFail() {
        return gameResultType == GameResultType.FAIL;
    }

    public void printResult() {
        if (nothing()) {
            System.out.print("낫싱\n");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(ballCount + "볼");
        }

        if (strikeCount > 0) {
            sb.append(" ").append(strikeCount + "스트라이크")
                    .append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    private boolean nothing() {
        return ballCount == 0 && strikeCount == 0;
    }
}
