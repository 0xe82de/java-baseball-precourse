package baseball.domain;

public abstract class Game {

    public abstract void start();

    protected abstract void play();

    protected abstract void restart();

    protected abstract void printInputText();

    public abstract void printMenu();
}
