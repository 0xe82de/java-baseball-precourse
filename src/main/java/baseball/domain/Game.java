package baseball.domain;

public abstract class Game {

    public abstract void start();

    protected abstract void printInputText();

    public abstract void printMenu();

    public abstract boolean win();
}
