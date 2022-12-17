package baseball.numberbaseball.controller;

import baseball.numberbaseball.model.entity.vo.GameResult;
import baseball.numberbaseball.model.service.GameService;
import baseball.numberbaseball.util.NumberVerifier;
import baseball.numberbaseball.view.GameResultForView;
import baseball.numberbaseball.view.GameView;
import baseball.numberbaseball.view.UserData;

public class GameController {

    private final GameService gameService;

    private final GameView gameView;

    public GameController(GameService gameService, GameView gameView) {
        this.gameService = gameService;
        this.gameView = gameView;
    }

    public void start() {
        UserData userData = gameView.start();
        play(userData);
    }

    private void play(UserData userData) {
        while (true) {
            NumberVerifier.verify(userData);
            GameResult gameResult = gameService.play(userData.toGameData());
            userData = gameView.printResult(gameResultForViewOf(gameResult));

            if (userData.restart()) {
                gameService.restart();
                userData = gameView.start();
            } else if (userData.quit()) {
                break;
            }
        }
    }

    private GameResultForView gameResultForViewOf(GameResult gameResult) {
        return new GameResultForView(
                gameResult.getGameResultType(),
                gameResult.getBallCount(),
                gameResult.getStrikeCount());
    }
}
