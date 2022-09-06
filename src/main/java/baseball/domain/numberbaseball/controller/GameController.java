package baseball.domain.numberbaseball.controller;

import baseball.domain.numberbaseball.view.GameResult;
import baseball.domain.numberbaseball.model.Game;
import baseball.domain.numberbaseball.view.GameView;
import baseball.domain.numberbaseball.view.UserRequest;

public abstract class GameController {

    protected Game game;

    protected GameView gameView;

    public abstract GameResult request(UserRequest userRequest);
}
