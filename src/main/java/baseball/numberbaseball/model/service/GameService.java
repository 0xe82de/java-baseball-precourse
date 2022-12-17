package baseball.numberbaseball.model.service;

import baseball.numberbaseball.model.entity.Game;
import baseball.numberbaseball.model.entity.vo.GameData;
import baseball.numberbaseball.model.entity.vo.GameResult;

public class GameService {

    private Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public GameResult play(GameData gameData) {
        return game.play(gameData);
    }

    public void restart() {
        game = new Game();
    }
}
