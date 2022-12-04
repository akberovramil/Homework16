public class WrongLoginException extends Exception{

    private Data data;

    public WrongLoginException(Data data) {
        this.data = data;
    }

    public WrongLoginException(String message, Data data) {
        super(message);
        this.data = data;
    }


}
