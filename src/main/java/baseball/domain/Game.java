package baseball.domain;

public abstract class Game {

    protected GameResult gameResult;

    public abstract void start();

    protected abstract void init();

    protected abstract void play();

    public abstract boolean over();

    public abstract void printMenu();

    public abstract void enterMenu();
}
