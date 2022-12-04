public class WrongPasswordException extends Exception {

    private Data data;

    public WrongPasswordException(Data data) {
        this.data = data;
    }

    public WrongPasswordException(String message, Data data) {
        super(message);
        this.data = data;
    }

}
