package baseball.numberbaseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameView {

    private static final int NUMBER_COUNT = 3;

    private static final String PLAY_ERROR_MESSAGE = "1 ~ 9 사이의 숫자를 " + NUMBER_COUNT + "개 입력해주세요.";

    private static final String MENU_ERROR_MESSAGE = "1 또는 2를 입력해주세요.";

    public UserData start() {
        return new UserData(RequestType.PLAY, printPlayScreenAndGetInput());
    }

    public UserData printResult(GameResultForView gameResultForView) {
        if (gameResultForView.userFail()) {
            gameResultForView.printResult();
            return new UserData(RequestType.PLAY, printPlayScreenAndGetInput());
        } else if (gameResultForView.userWin()) {
            winScreen(gameResultForView);
            return new UserData(getRequestType(), null);
        }

        throw new IllegalStateException("Invalid result");
    }

    private void verify(List<Integer> numbers) {
        if (invalidSize(numbers) || outOfBound(numbers)) {
            throw new IllegalArgumentException(PLAY_ERROR_MESSAGE);
        }
    }

    private boolean invalidSize(List<Integer> numbers) {
        return numbers.size() != NUMBER_COUNT;
    }

    private boolean outOfBound(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> !(1 <= number && number <= 9));
    }

    private List<Integer> printPlayScreenAndGetInput() {
        playScreen();
        List<Integer> numbers = getThreeNumbers();
        verify(numbers);
        return numbers;
    }

    private List<Integer> getThreeNumbers() {
        return Console.readLine().chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
    }

    private RequestType getRequestType() {
        return RequestType.findByNumber(getMenuNumber());
    }

    private List<RequestType> getPossibleMenus() {
        return Arrays.asList(RequestType.RESTART, RequestType.QUIT);
    }

    private void winScreen(GameResultForView gameResultForView) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        gameResultForView.printResult();
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.%n",
                RequestType.RESTART.getMenuNumber(),
                RequestType.QUIT.getMenuNumber());
    }

    private void playScreen() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private int getMenuNumber() {
        String menuNumber = Console.readLine();
        if (verifyMenu(menuNumber)) {
            return Integer.parseInt(menuNumber);
        }

        throw new IllegalArgumentException(MENU_ERROR_MESSAGE);
    }

    private boolean verifyMenu(String menuNumber) {
        List<RequestType> possibleMenus = getPossibleMenus();
        return possibleMenus.stream()
                .map(RequestType::getMenuNumber)
                .map(String::valueOf)
                .anyMatch(number -> number.equals(menuNumber));
    }
}
