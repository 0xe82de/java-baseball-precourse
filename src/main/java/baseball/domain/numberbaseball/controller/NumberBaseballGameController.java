package baseball.domain.numberbaseball.controller;

import baseball.domain.numberbaseball.model.Game;
import baseball.domain.numberbaseball.util.RandomNumber;
import baseball.domain.numberbaseball.view.GameResult;
import baseball.domain.numberbaseball.view.GameResultType;
import baseball.domain.numberbaseball.view.NumberBaseballGameResult;
import baseball.domain.numberbaseball.view.UserRequest;

public class NumberBaseballGameController extends GameController {

    private final Game game;

    private final RandomNumber randomNumber;

    public NumberBaseballGameController(Game game, RandomNumber randomNumber) {
        this.game = game;
        this.randomNumber = randomNumber;
    }

    @Override
    public GameResult request(UserRequest userRequest) {
        if (userRequest.start() || userRequest.restart()) {
            return game.init(randomNumber.getThreeNumbers());
        } else if (userRequest.play()) {
            return game.play(userRequest.getData());
        } else if (userRequest.quit()) {
            return new NumberBaseballGameResult(GameResultType.EXIT, null, null);
        }

        throw new IllegalStateException("Invalid request");
    }
}
