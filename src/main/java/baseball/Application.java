package baseball;

import baseball.domain.numberbaseball.controller.NumberBaseballGameController;
import baseball.domain.numberbaseball.model.NumberBaseballGame;
import baseball.domain.numberbaseball.util.NextstepRandomNumber;
import baseball.domain.numberbaseball.view.GameResult;
import baseball.domain.numberbaseball.view.NumberBaseballGameView;
import baseball.domain.numberbaseball.view.UserRequest;
import baseball.domain.numberbaseball.view.UserRequestType;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        NumberBaseballGameController gameController = new NumberBaseballGameController(
                new NumberBaseballGame(),
                new NextstepRandomNumber());

        NumberBaseballGameView gameView = new NumberBaseballGameView(new Scanner(System.in));

        UserRequest userRequest = initRequest();
        GameResult gameResult = null;
        while (!userRequest.quit()) {
            gameResult = gameController.request(userRequest);
            userRequest = gameView.printResult(gameResult);
        }
    }

    private static UserRequest initRequest() {
        return new UserRequest(UserRequestType.START, null);
    }
}
