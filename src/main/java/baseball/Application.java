package baseball;

import baseball.domain.Game;
import baseball.domain.numberbaseball.NumberBaseballGame;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Game game = new NumberBaseballGame();
        game.start();
    }
}
