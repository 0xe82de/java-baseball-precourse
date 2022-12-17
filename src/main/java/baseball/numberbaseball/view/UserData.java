package baseball.numberbaseball.view;

import baseball.numberbaseball.model.entity.vo.GameData;

import java.util.List;

public class UserData {

    private final RequestType requestType;

    private final List<Integer> numbers;

    public UserData(RequestType requestType, List<Integer> numbers) {
        this.requestType = requestType;
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean restart() {
        return requestType == RequestType.RESTART;
    }

    public boolean quit() {
        return requestType == RequestType.QUIT;
    }

    public GameData toGameData() {
        return new GameData(numbers);
    }
}
