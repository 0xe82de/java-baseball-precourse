package baseball.domain.numberbaseball.util;

import java.util.List;

public class NumberValidator {

    public static boolean existsDuplicateNumber(List<Integer> numbers) {
        final int SIZE = numbers.size();

        for (int i = 0; i < SIZE; i++) {
            for (int j = i + 1; j < SIZE; j++) {
                if (numbers.get(i).intValue() == numbers.get(j).intValue()) {
                    return true;
                }
            }
        }

        return false;
    }
}
