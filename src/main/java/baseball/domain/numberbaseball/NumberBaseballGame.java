package baseball.domain.numberbaseball;

import baseball.domain.Game;
import baseball.domain.numberbaseball.util.NextstepRandomNumber;
import baseball.domain.numberbaseball.util.NumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberBaseballGame extends Game {

    private Player userPlayer;

    private Player computer;

    private Scanner sc;

    @Override
    public void start() {
        computer = new Computer(new NextstepRandomNumber().getThreeNumbers());
        sc = new Scanner(System.in);
        play();
    }

    private void play() {
        while (true) {
            printInputText();
            userPlayer = new UserPlayer(getNumbersFromInput());

            if (win()) {
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

    private void restart() {
        computer = new Computer(new NextstepRandomNumber().getThreeNumbers());
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
        for (char number : input) {
            if (!('1' <= number && number <= '9')) {
                throw new IllegalArgumentException();
            }
        }

        for (char number : input) {
            numbers.add(number - '0');
        }

        if (NumberValidator.existsDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
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
