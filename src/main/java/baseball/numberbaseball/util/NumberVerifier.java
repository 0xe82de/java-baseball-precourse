package baseball.numberbaseball.util;

import baseball.numberbaseball.view.UserData;

import java.util.List;

public class NumberVerifier {

    private NumberVerifier() {
    }

    public static void verify(UserData userData) {
        if (existsDuplicateNumber(userData.getNumbers())) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }

    private static boolean existsDuplicateNumber(List<Integer> numbers) {
        return numbers.size() != (int) numbers.stream()
                .distinct()
                .count();
    }
}
