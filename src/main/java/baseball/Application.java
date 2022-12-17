package baseball;

import baseball.numberbaseball.controller.GameController;
import baseball.numberbaseball.model.entity.Game;
import baseball.numberbaseball.model.service.GameService;
import baseball.numberbaseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new GameService(new Game()),
                new GameView());

        gameController.start();
    }
}
