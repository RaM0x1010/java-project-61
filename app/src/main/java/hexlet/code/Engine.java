package hexlet.code;

public class Engine {

    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void greeting() {
        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        //
    }

    public void finishMessage(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("Congratulations, " + userName);
        } else {
            System.out.println("Let's try again, " + userName);
        }
    }
}
