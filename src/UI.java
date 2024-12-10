import java.util.Scanner;

public class UI implements Welcome {
    Scanner scn = new Scanner(System.in);

    public void ui() {
        LoginOrRegister LOR = new LoginOrRegister();
        LOR.registerOrLogin();

        String username = LOR.getUsername();

        welcomeText(username);
        System.out.println("What would u like to do?");
        System.out.println("1 - See alcohol database 2 - Search for specific alcohol");

        int option = scn.nextInt();
        switch (option) {
            case 1:
                System.out.println("OUR ALCOHOLS");
                break;
            case 2:
                System.out.println("SEARCH ALCOHOL");
                break;
        }
    }

    @Override
    public void welcomeText() {
        System.out.println("WELCOME, USER!");
    }

    public void welcomeText(String username) {
        System.out.println("WELCOME, " + username + "!");
    }
}