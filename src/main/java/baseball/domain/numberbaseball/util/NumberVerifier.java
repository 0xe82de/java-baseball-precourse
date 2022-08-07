package baseball.domain.numberbaseball.util;

import java.util.List;

public class NumberVerifier {

    public static void verify(List<Integer> numbers) {
        if (existsDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }

    private static boolean existsDuplicateNumber(List<Integer> numbers) {
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
