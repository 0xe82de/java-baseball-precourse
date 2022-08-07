package baseball.domain;

public abstract class Game {

    public abstract void start();

    protected abstract void init();

    public abstract boolean over();

    protected abstract void play();

    protected abstract void printInputText();

    public abstract void printMenu();

    public abstract void enterMenu();
}
