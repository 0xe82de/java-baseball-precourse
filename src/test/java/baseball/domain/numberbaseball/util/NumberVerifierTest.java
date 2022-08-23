package baseball.domain.numberbaseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberVerifierTest {

    @DisplayName("중복되는 숫자가 있는 경우 true 리턴")
    @Test
    void returnTrueWhenNumbersOverlap() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = NumberVerifier.class.getDeclaredMethod("existsDuplicateNumber", List.class);
        method.setAccessible(true);

        boolean result = (boolean) method.invoke(NumberVerifier.class, Arrays.asList(1, 2, 2));
        assertThat(result).isTrue();
    }

    @DisplayName("중복되는 숫자가 없는 경우 false 리턴")
    @Test
    void returnFalseWhenNumbersNotOverlap() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = NumberVerifier.class.getDeclaredMethod("existsDuplicateNumber", List.class);
        method.setAccessible(true);

        boolean result = (boolean) method.invoke(NumberVerifier.class, Arrays.asList(1, 2, 3));
        assertThat(result).isFalse();
    }

    @DisplayName("중복되는 숫자가 있으면 예외가 발생한다.")
    @Test
    void occurExceptionWhenNumbersNotOverlap() {
        assertThatThrownBy(() -> NumberVerifier.verify(Arrays.asList(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 숫자를 입력해주세요.");
    }

    @DisplayName("중복되는 숫자가 없으면 예외가 발생하지 않는다.")
    @Test
    void notOccurExceptionWhenNumbersNotOverlap() {
        NumberVerifier.verify(Arrays.asList(1, 2, 3));
    }
}