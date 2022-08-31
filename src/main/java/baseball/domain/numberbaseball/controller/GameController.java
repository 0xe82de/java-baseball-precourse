package baseball.domain.numberbaseball.controller;

import baseball.domain.GameResult;
import baseball.domain.numberbaseball.model.Game;
import baseball.domain.numberbaseball.view.GameView;

public abstract class GameController {

    protected Game game;

    protected GameView gameView;

    public abstract void start();

    public abstract GameResult play();

    public abstract void displayResult(GameResult gameResult);
}
