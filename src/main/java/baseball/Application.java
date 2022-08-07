package baseball;

import baseball.domain.Game;
import baseball.domain.numberbaseball.NumberBaseballGame;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Scanner sc = new Scanner(System.in);
        Game game = new NumberBaseballGame(sc);

        do {
            game.start();
            game.printMenu();
            game.enterMenu();
        } while (!game.over());
    }
}
