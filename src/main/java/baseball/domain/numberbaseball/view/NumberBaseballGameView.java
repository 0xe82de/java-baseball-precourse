package baseball.domain.numberbaseball.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static baseball.domain.numberbaseball.view.UserRequestType.PLAY;

public class NumberBaseballGameView extends GameView {

    private final Scanner scanner;

    public NumberBaseballGameView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public UserRequest start() {
        return play();
    }

    @Override
    public UserRequest printResult(GameResult result) {
        if (result.init() || result.userFail()) {
            if (result.userFail()) {
                result.printResult();
            }

            playScreen();


            return new UserRequest(PLAY, getThreeNumbers());
        } else if (result.userWin()) {
            winScreen();
            return new UserRequest(getMenu(), null);
        } else if (result.exit()) {
            return new UserRequest(UserRequestType.EXIT, null);
        }

        throw new IllegalStateException("Invalid result");
    }

    private UserRequest play() {
        playScreen();
        return new UserRequest(PLAY, getThreeNumbers());
    }

    private List<Integer> getThreeNumbers() {
        final int NUMBER_COUNT = 3;

        char[] input = scanner.next().toCharArray();

        if (input.length != NUMBER_COUNT) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자를 3개 입력해주세요.");
        }

        for (char c : input) {
            if (!('1' <= c && c <= '9')) {
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자를 3개 입력해주세요.");
            }
        }

        List<Integer> numbers = new ArrayList<>(NUMBER_COUNT);
        for (char c : input) {
            numbers.add(c - '0');
        }

        return numbers;
    }

    private UserRequestType getMenu() {
        int input = getMenuNumber();

        List<UserRequestType> possibleMenus = getPossibleMenus();
        for (UserRequestType possibleMenu : possibleMenus) {
            if (possibleMenu.getNumber() == input) {
                return possibleMenu;
            }
        }

        throw new IllegalArgumentException("메뉴를 잘못 입력하셨습니다.");
    }

    private List<UserRequestType> getPossibleMenus() {
        return Arrays.asList(UserRequestType.RESTART, UserRequestType.EXIT);
    }

    private void winScreen() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", UserRequestType.RESTART.getNumber(), UserRequestType.EXIT.getNumber());
    }

    private void playScreen() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private int getMenuNumber() {
        return scanner.nextInt();
    }
}
