package baseball.domain.numberbaseball;

import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.domain.numberbaseball.util.NextstepRandomNumber;
import baseball.domain.numberbaseball.util.NumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberBaseballGame extends Game {

    private Player userPlayer;

    private Player computer;

    private GameResult gameResult;

    private Scanner sc;

    @Override
    public void start() {
        userPlayer = new UserPlayer();
        computer = new Computer(new NextstepRandomNumber().getThreeNumbers());
        gameResult = new NumberBaseballGameResult(userPlayer, computer);
        sc = new Scanner(System.in);

        play();
    }

    @Override
    protected void play() {
        while (true) {
            printInputText();
            userPlayer.changeNumbers(getNumbersFromInput());

            gameResult.printResult();
            if (gameResult.userPlayerWin()) {
                printMenu();
                int menu = getMenuFromInput();

                if (menu == 1) {
                    // 새로 시작
                    restart();
                } else {
                    // 종료
                    break;
                }
            }
        }
    }

    @Override
    protected void restart() {
        userPlayer = new UserPlayer();
        computer = new Computer(new NextstepRandomNumber().getThreeNumbers());
        gameResult = new NumberBaseballGameResult(userPlayer, computer);
    }

    private int getMenuFromInput() {
        int menu = sc.nextInt();

        if (!(1 <= menu && menu <= 2)) {
            throw new IllegalArgumentException();
        }

        return menu;
    }

    private List<Integer> getNumbersFromInput() {
        List<Integer> numbers = new ArrayList<>();

        char[] input = sc.next().toCharArray();
        final int SIZE = input.length;
        if (!(0 < SIZE && SIZE < 4)) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        for (char number : input) {
            if (!('1' <= number && number <= '9')) {
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자를 입력해주세요.");
            }

            numbers.add(number - '0');
        }

        if (NumberValidator.existsDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }

        return numbers;
    }

    @Override
    protected void printInputText() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printMenu() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
