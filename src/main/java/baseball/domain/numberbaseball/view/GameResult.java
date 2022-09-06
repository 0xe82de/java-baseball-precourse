package baseball.domain.numberbaseball.view;

public abstract class GameResult {

    public abstract boolean init();

    public abstract boolean userWin();

    public abstract boolean userFail();

    public abstract void printResult();

    public abstract boolean exit();
}
