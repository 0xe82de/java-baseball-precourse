package baseball.domain.numberbaseball.view;

public class UserRequest {

    private final UserRequestType userRequestType;

    private final Object data;

    public UserRequest(UserRequestType userRequestType, Object data) {
        this.userRequestType = userRequestType;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public boolean start() {
        return userRequestType == UserRequestType.START;
    }

    public boolean play() {
        return userRequestType == UserRequestType.PLAY;
    }

    public boolean restart() {
        return userRequestType == UserRequestType.RESTART;
    }

    public boolean quit() {
        return userRequestType == UserRequestType.EXIT;
    }
}
