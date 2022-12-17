package baseball.numberbaseball.view;

import java.util.Arrays;

public enum RequestType {

    PLAY(0), RESTART(1), QUIT(2);

    private final int menuNumber;

    RequestType(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public static RequestType findByNumber(int number) {
        return Arrays.stream(values())
                .filter(requestType -> requestType.getMenuNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
