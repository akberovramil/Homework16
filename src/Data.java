public class Data {

    public  String login;
    public  String password;
    public  String confirmPassword;

    public Data(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public static boolean checkData(String login, String password, String confirmPassword) {

        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    private static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        Data data = new Data(login, password, confirmPassword);
        String n = "";

        if (login.length() > 20 || login.isEmpty() || !login.matches(".*\\w.*")) {
            try {
                throw new WrongLoginException(data);
            } catch (WrongLoginException e) {
                throw new RuntimeException("Ошибка логина");

            }
        } else if (password.length() > 20 || password.isEmpty() || !password.matches(".*\\w.*")) {
            try {
                throw new WrongPasswordException(data);
            } catch (WrongPasswordException e) {
                throw new RuntimeException("Неверный пароль");
            }
        } else if (confirmPassword.length() > 20 || confirmPassword.isEmpty() || !confirmPassword.equals(password)) {
            try {
                throw new WrongPasswordException(data);
            } catch (WrongPasswordException e) {
                throw new RuntimeException("Неверное подтверждение пароля");
            }
        } else {
            System.out.println("Все данные верны");
        }

    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }




}
