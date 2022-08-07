package baseball.domain.numberbaseball;

import baseball.domain.numberbaseball.util.NextstepRandomNumber;

public class Computer extends Player {

    public Computer() {
        this.numbers = new NextstepRandomNumber().getThreeNumbers();
    }
}
