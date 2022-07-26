package baseball.domain.numberbaseball;

import baseball.domain.GameResult;

import java.util.List;

public class NumberBaseballGameResult extends GameResult {

    private final Player userPlayer;

    private final Player computer;

    public NumberBaseballGameResult(Player userPlayer, Player computer) {
        this.userPlayer = userPlayer;
        this.computer = computer;
    }

    @Override
    public boolean userPlayerWin() {
        return userPlayer.getNumbers().equals(computer.getNumbers());
    }

    @Override
    public void printResult() {
        List<Integer> userNumbers = userPlayer.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        int ball = 0;
        int strike = 0;
        final int SIZE = userNumbers.size();
        for (int i = 0; i < SIZE; i++) {
            int userNumber = userNumbers.get(i);
            for (int j = 0; j < SIZE; j++) {
                int computerNumber = computerNumbers.get(j);

                if (userNumber == computerNumber) {
                    if (i == j) {
                        ++strike;
                    } else {
                        ++ball;
                    }
                }
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        } else {
            if (ball > 0) {
                System.out.print(ball + "볼");
            }

            if (strike > 0) {
                if (ball > 0) {
                    System.out.print(" ");
                }

                System.out.print(strike + "스트라이크");
            }
        }
        System.out.println();
    }
}
