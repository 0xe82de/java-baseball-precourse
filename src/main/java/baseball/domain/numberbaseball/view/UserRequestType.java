package baseball.domain.numberbaseball.view;

public enum UserRequestType {

    START(0), RESTART(1), EXIT(2), PLAY(3);

    private final int number;

    UserRequestType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
