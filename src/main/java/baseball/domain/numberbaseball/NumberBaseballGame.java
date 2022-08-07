package baseball.domain.numberbaseball;

import baseball.domain.Game;
import baseball.domain.numberbaseball.util.NumberVerifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberBaseballGame extends Game {

    private Player userPlayer;

    private Player computer;

    private boolean gameOver;

    private final Scanner sc;

    public NumberBaseballGame(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void start() {
        init();
        play();
    }

    @Override
    protected void init() {
        userPlayer = new UserPlayer();
        computer = new Computer();
        gameResult = new NumberBaseballGameResult(userPlayer, computer);
    }

    @Override
    protected void play() {
        List<Integer> numbers = null;
        do {
            printPlayDisplay();
            numbers = enterNumbersFromUser();
            NumberVerifier.verify(numbers);
            userPlayer.changeNumbers(numbers);
            gameResult.printResult();
        } while (!gameResult.userPlayerWin());
    }

    @Override
    public void printMenu() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public void enterMenu() {
        int menu = sc.nextInt();

        final int RESTART = 1;
        final int QUIT = 2;

        if (!(RESTART <= menu && menu <= QUIT)) {
            throw new IllegalArgumentException();
        }

        gameOver = menu == QUIT;
    }

    @Override
    public boolean over() {
        return gameOver;
    }

    private List<Integer> enterNumbersFromUser() {
        char[] values = sc.next().toCharArray();
        if (incorrectValue(values) || incorrectSize(values)) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자를 3개 입력해주세요.");
        }

        return makeNumbers(values);
    }

    private boolean incorrectValue(char[] values) {
        for (char number : values) {
            if (!('1' <= number && number <= '9')) {
                return true;
            }
        }

        return false;
    }

    private boolean incorrectSize(char[] values) {
        return values.length != 3;
    }

    private List<Integer> makeNumbers(char[] values) {
        List<Integer> numbers = new ArrayList<>(values.length);
        for (char value : values) {
            numbers.add(value - '0');
        }

        return numbers;
    }

    private void printPlayDisplay() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}
