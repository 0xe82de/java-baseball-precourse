package baseball.domain.numberbaseball.view;

public class NumberBaseballGameResult extends GameResult {

    private final GameResultType gameResultType;

    private final Integer ballCount;

    private final Integer strikeCount;

    public NumberBaseballGameResult(GameResultType gameResultType, Integer ballCount, Integer strikeCount) {
        this.gameResultType = gameResultType;
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    @Override
    public boolean init() {
        return gameResultType == GameResultType.INIT;
    }

    @Override
    public boolean userWin() {
        return gameResultType == GameResultType.SUCCESS;
    }

    @Override
    public boolean userFail() {
        return gameResultType == GameResultType.FAIL;
    }

    @Override
    public boolean exit() {
        return gameResultType == GameResultType.EXIT;
    }

    @Override
    public void printResult() {
//        List<Integer> userNumbers = userPlayer.getNumbers();
//        List<Integer> computerNumbers = computer.getNumbers();
//
//        int ball = 0;
//        int strike = 0;
//        final int SIZE = userNumbers.size();
//        for (int i = 0; i < SIZE; i++) {
//            int userNumber = userNumbers.get(i);
//            for (int j = 0; j < SIZE; j++) {
//                int computerNumber = computerNumbers.get(j);
//
//                if (userNumber == computerNumber) {
//                    if (i == j) {
//                        ++strike;
//                    } else {
//                        ++ball;
//                    }
//                }
//            }
//        }

        if (ballCount == null) {
            throw new IllegalStateException("strikeCount is null");
        } else if (strikeCount == null) {
            throw new IllegalStateException("ballCount is null");
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        } else {
            if (ballCount > 0) {
                System.out.print(ballCount + "볼");
            }

            if (strikeCount > 0) {
                if (ballCount > 0) {
                    System.out.print(" ");
                }

                System.out.print(strikeCount + "스트라이크");
            }
        }
        System.out.println();
    }
}
