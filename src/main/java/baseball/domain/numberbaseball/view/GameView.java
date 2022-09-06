package baseball.domain.numberbaseball.view;

public abstract class GameView {

    public abstract UserRequest start();

    public abstract UserRequest printResult(GameResult result);
}
