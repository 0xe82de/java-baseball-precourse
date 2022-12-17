package baseball.numberbaseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumber {

    private RandomNumber() {
    }

    public static List<Integer> getThreeNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            numbers.add(number);
        }

        return new ArrayList<>(numbers);
    }
}
