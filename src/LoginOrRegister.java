import java.util.Scanner;

public class LoginOrRegister implements Welcome {
    Scanner scn = new Scanner(System.in);
    private String username;

    public void registerOrLogin() {
        welcomeText();
        int choose = scn.nextInt();

        switch (choose) {
            case 1:
                // login
                System.out.println("Enter your username: ");
                username = scn.next();
                System.out.println("Enter your password: ");
                String user_password = scn.next();
                break;
            case 2:
                // register
                System.out.println("Enter your username: ");
                username = scn.next();
                System.out.println("Enter your password: ");
                String new_user_password = scn.next();
                break;
        }
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void welcomeText() {
        System.out.println("WELCOME TO THE SYSTEM! PLEASE CHOOSE 1 - LOGIN OR 2 - REGISTER");
    }
}